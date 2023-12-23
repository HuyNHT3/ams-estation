import React, { useEffect, useRef } from 'react';
import { getAllVocabulary } from '../../api/VocabularyDataSource';
import './CheckVocabulary.scss'
import CheckVocabularyItem from './CheckVocabularyItem';
import { useMemo, useState } from 'react';
import ResultTable from './ResultTable';

function CheckVocabularyBody() {
    const RESTART = 'RESTART'
    const RESULT = 'RESULT'

    let [vocabIndex, setVocabIndex] = useState(0);
    const [vocabList, setVocabList] = useState(null);
    let [currentWord, setCurrentWord] = useState(null);
    let [isFinish, setIsFinish] = useState(false);
    let [rightAnswer, setRightAnswer] = useState([]);
    let [wrongAnswer, setWrongAnswer] = useState([]);
    let [userAnswer, setUserAnswer] = useState('');
    let [isShowResult, setIsShowResult] = useState(false);

    useMemo(() => {
        getAllVocabulary().then((res) => {
            setVocabList(res.data)
            setCurrentWord(res.data.vocabularyList[vocabIndex])
        })
    }, [!vocabList]);

    function buildRightAnwser(data) {
        setRightAnswer(data);
    }

    function buildWrongAnwser(data) {
        setWrongAnswer(data);
    }

    function nextVocabulary() {
        const index = vocabIndex + 1;
        setVocabIndex(index);
    }

    function resetPage() {
        window.location.reload(true);
    }
    
    function showResultTable() {
        setIsShowResult(!isShowResult);
    }

    function handleOnKeyPress(e) {
        
        if (e.key === 'Enter') {
            
            if(userAnswer.toLocaleUpperCase() === RESTART) {
                resetPage();
            }

            if(userAnswer.toLocaleUpperCase() === RESULT) {
                showResultTable();
            }

            if(userAnswer.toLocaleUpperCase() !== RESTART && userAnswer.toLocaleUpperCase() !== RESULT) {
                if (vocabIndex < vocabList.vocabularyList.length) {
                    if(userAnswer.toLocaleUpperCase() === currentWord.name.toLocaleUpperCase()) {
                        var tempRightAnswer = rightAnswer;
                        tempRightAnswer.push(currentWord);
                                buildRightAnwser(tempRightAnswer);
                     }
                     else {
                        var tempWrongAnswer = wrongAnswer;
                        tempWrongAnswer.push(currentWord);
                        buildWrongAnwser(tempWrongAnswer);
                     }
               
                if (vocabList) {
                    setCurrentWord(vocabList.vocabularyList[vocabIndex + 1]);
                }

                nextVocabulary();
            }
            if (vocabIndex >= vocabList.vocabularyList.length - 1) {
                setIsFinish(true);
            }
            setUserAnswer('');

            }
        }
    }

    return (
        <div className='vocab-body'>
            <div className='row content'>
                <div className='col-12 shadow p-3 mb-3 bg-body rounded'>
                    <div className='text-end'>
                        {!!rightAnswer && (<span className='text-success fw-bolder'>Right: {rightAnswer.length}</span>)} |
                        {!!wrongAnswer && (<span className='text-danger fw-bolder'> Wrong: {wrongAnswer.length}</span>)}
                    </div>
                    {!isFinish && (
                        <CheckVocabularyItem
                            vocabList={vocabList}
                            currentWord={currentWord}
                            isFinish={isFinish}
                        />)
                    }
                    {!!isFinish && (
                        <h1 className='mt-5 text-center text-warning fw-bolder text-shadow'>Congratulation, you finshed. 
                        <br/> Please type "restart" for playing again, and type "result" to see the right answers !!!</h1>
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
                            value={userAnswer}
                        />
                    </div>
                </div>
            </div>
            <ResultTable
                isShowResult={isShowResult}
                setIsShowResult={setIsShowResult}
                rightAnswer={rightAnswer}
            />
        </div>
    );
}

export default CheckVocabularyBody;