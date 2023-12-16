import 'bootstrap/dist/css/bootstrap.css';
import './CheckVocabulary.scss';
import { Card } from 'reactstrap';

function replaceByDash(word) {
  const wordArray = word.split(' ');
  let phrase = '';
  for(var i=0; i < wordArray.length; i++)
  {
    let temp = '';
    for(var j=0; j < wordArray[i].length; j++) {
      if(j === 0 || j === (wordArray[i].length -1)) {
        temp += wordArray[i].charAt(j) + ' ';
      }
      else {
        temp += '_ ';
      }
    }
    phrase += temp +' ';
  }
  return phrase.trim();
}

function CheckVocabularyItem(
  {
    vocabList,
    currentWord
  }
  ) {
  

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
                    <span className="badge badge-alert">Topic: {currentWord.idTopic}</span>
                    <span className="badge badge-primary ms-2">Part Of Speech: {currentWord.partOfSpeech}</span>
                  </div>
                  <h1 className="fw-bolder ms-3 text-center">
                    {replaceByDash(currentWord.name)}
                  </h1>
                </Card>


                  {currentWord.meaning.map((item) => {
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
