import axios from "axios";
import { useMemo, useState } from "react";
import 'bootstrap/dist/css/bootstrap.css';
import './CheckVocabulary.scss';
import { Card } from 'reactstrap';

function getAllVocab() {
  return axios.get("https://e-tips-static-site.s3.amazonaws.com/assests/data/vocabulary.json")
}

function replaceByDash(word) {
  const wordArray = word.split(' ');
  console.log(wordArray.length);
  for(var i=0; i < wordArray.length; i++)
  {
    let tem ="";
    for(var j=0; j < wordArray[i].length; j++) {
        if(j === 0 || j === (wordArray[i].length-1)) tem += word[i].charAt(j);
        else tem += "_.";
    }
    console.log(tem);
     console.log("-----------------")
  }
  return "";
}
function CheckVocabularyItem() {
  const [vocabList, setVocabList] = useState(null);

  useMemo(() => {
    getAllVocab().then((res) => {
      setVocabList(res.data)
    })
  }, [vocabList === '']);

  return (
    <div className="App">
      {
          !!vocabList && (
              <div>
                <Card 
                    color="secondary"
                    outline
                >
                  <div>
                    <span className="badge badge-alert">Topic: {vocabList.vocabularyList[0].idTopic}</span>
                    <span className="badge badge-primary ms-2">Part Of Speech: {vocabList.vocabularyList[0].partOfSpeech}</span>
                  </div>
                  <h1 className="fw-bolder ms-3 text-center">
                    {replaceByDash(vocabList.vocabularyList[0].name)}
                    {console.log(replaceByDash(vocabList.vocabularyList[0].name))}
                  </h1>
                </Card>


                  {vocabList.vocabularyList[0].meaning.map((item) => {
                    return (
                        <Card 
                        className="my-3"
                        color="secondary"
                        outline
                        >
                          <div className="text-start">
                            <span className="badge badge-warning me-1">Meaning</span>
                            {item.value}
                            {item.example.map((item) => {
                              return <div className="ms-5">
                                <span className="badge badge-info me-1">Example</span>
                                {item}
                              </div>
                            })}
                          </div>
                        </Card>
                    )
                  })}
              </div>
          )
      }

    </div>
  );
}

export default CheckVocabularyItem;
