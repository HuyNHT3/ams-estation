import React from 'react';
import { getAllVocabulary } from '../../api/VocabularyDataSource';
import './CheckVocabulary.scss'


function CheckVocabularyBody() {
    getAllVocabulary().then((response) => console.log(response.data))

    return (
        <div className='vocab-body'>
            <div className='row content'>
                <div className='col-12 shadow p-3 mb-3 bg-body rounded'></div>
            </div>
            <div className='row inputBox'>
                <div className='col-12'>
                    <form>
                        <div class="">
                            <input
                                type="text"
                                class="form-control shadow p-3 mb-5 bg-body rounded"
                                id="exampleInputEmail1"
                                aria-describedby="emailHelp"
                                placeholder='When start checking progress for learning vocabulary, please typing word here, and press enter after finish typing!' 
                            />
                        </div>
                    </form>
                </div>
            </div>
        </div>
    );
}

export default CheckVocabularyBody;