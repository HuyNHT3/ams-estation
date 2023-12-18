import React, { useRef } from 'react';
import { getAllVocabulary } from '../../api/VocabularyDataSource';
import './CheckVocabulary.scss'
import CheckVocabularyItem from './CheckVocabularyItem';
import { useMemo, useState } from "react";

function CheckVocabularyBody() {
    let [vocabIndex, setVocabIndex] = useState(0);
    const [vocabList, setVocabList] = useState(null);
    let [currentWord, setCurrentWord] = useState(null);
    let [isFinish, setIsFinish] = useState(false);
    let [rightAnswer, setRightAnswer] = useState([]);
    let [wrongAnswer, setWrongAnswer] = useState([]);
    let [userAnswer, setUserAnswer] = useState('');
    let [count, setCount] = useState(0);

    useMemo(() => {
        getAllVocabulary().then((res) => {
            setVocabList(res.data)
            setCurrentWord(res.data.vocabularyList[vocabIndex])
        })
    }, [vocabList === '']);



    function handleOnKeyPress(e) {
        
        if (e.key === 'Enter') {
    
             console.log("userAnswer: " + userAnswer);

            if (vocabIndex < vocabList.vocabularyList.length) {
                if(userAnswer === currentWord.name) {
                    var tempAnswer = rightAnswer;
                            tempAnswer.push(currentWord);
                            setRightAnswer(tempAnswer);
                            setCount(count++);
                            console.log("rightAnswer: " + JSON.stringify(rightAnswer));
                            console.log("count: " + count);
                 }
                 else {
                    var tempAnswer = wrongAnswer;
                            tempAnswer.push(currentWord);
                            setWrongAnswer(tempAnswer);
                            console.log("wrongAnswer: " + JSON.stringify(wrongAnswer))
                 }

                if (vocabList) {
                    setCurrentWord(vocabList.vocabularyList[vocabIndex + 1]);
                }
                setVocabIndex(vocabIndex++);
            }

            if (vocabIndex === vocabList.vocabularyList.length) {
                setIsFinish(true);
                setRightAnswer([]);
                setWrongAnswer([]);
            }
        }
    }

    return (
        <div className='vocab-body'>
            <div className='row content'>
                <div className='col-12 shadow p-3 mb-3 bg-body rounded'>
                    <div className='text-end'>
                        <span className='text-success fw-bolder'>Right: {count}</span> |
                        {!!wrongAnswer && (<span className='text-danger fw-bolder'> Wrong: {wrongAnswer.length}</span>)}
                    </div>
                    {!isFinish && (
                        <CheckVocabularyItem
                            vocabList={vocabList}
                            currentWord={currentWord}
                        />)
                    }
                    {!!isFinish && (
                        <h1>Congratulation, you finshed !!!</h1>
                    )}

                </div>
            </div>
            <div className='row inputBox'>
                <div className='col-12 p-0'>
                    <div class="">
                        <input
                            autoFocus
                            type="text"
                            class="form-control shadow bg-body rounded"
                            id="exampleInputEmail1"
                            aria-describedby="emailHelp"
                            placeholder='When start checking progress for learning vocabulary, please typing word here, and press enter after finish typing!'
                            onKeyDown={handleOnKeyPress}
                            onChange={(e) => setUserAnswer(e.target.value)}
                        />
                    </div>
                </div>
            </div>
        </div>
    );
}

export default CheckVocabularyBody;