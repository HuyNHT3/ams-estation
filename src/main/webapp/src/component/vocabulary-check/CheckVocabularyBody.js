import React from 'react';
import { getAllVocabulary } from '../../api/VocabularyDataSource';
import './CheckVocabulary.scss'
import CheckVocabularyItem from './CheckVocabularyItem';
import { useMemo, useState } from "react";

function CheckVocabularyBody() {
    let [vocabIndex, setVocabIndex] = useState(0);
    const [vocabList, setVocabList] = useState(null);
    let [currentWord, setCurrentWord] = useState(null);
    let [isFinish, setIsFinish] = useState(false);

    useMemo(() => {
        getAllVocabulary().then((res) => {
            setVocabList(res.data)
            setCurrentWord(res.data.vocabularyList[vocabIndex])
        })
    }, [vocabList === '']);

    function handleOnKeyPress(e) {
        e.preventDefault();

        if (e.key === 'Enter') {
            if (vocabIndex < vocabList.vocabularyList.length) {
                if (vocabList) {
                    setCurrentWord(vocabList.vocabularyList[vocabIndex + 1]);
                }
                setVocabIndex(vocabIndex++);
            }

            if (vocabIndex >= vocabList.vocabularyList.length) setIsFinish(true);
        }
    }

    return (
        <div className='vocab-body'>
            <div className='row content'>
                <div className='col-12 shadow p-3 mb-3 bg-body rounded'>
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
                    <form>
                        <div class="">
                            <input
                                type="text"
                                class="form-control shadow bg-body rounded"
                                id="exampleInputEmail1"
                                aria-describedby="emailHelp"
                                placeholder='When start checking progress for learning vocabulary, please typing word here, and press enter after finish typing!'
                                onKeyDown={handleOnKeyPress}
                            />
                        </div>
                    </form>
                </div>
            </div>
        </div>
    );
}

export default CheckVocabularyBody;