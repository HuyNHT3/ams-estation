import React, { useState } from 'react';
import { Table, Modal, ModalHeader, ModalBody, ModalFooter } from 'reactstrap';

function ResultTable({ isShowResult, setIsShowResult, rightAnswer }) {

  const toggle = () => setIsShowResult(!isShowResult);

  return !!rightAnswer && (
    <div>
      <Modal isOpen={isShowResult} toggle={toggle} fullscreen>
        <ModalHeader toggle={toggle} className='text-danger fw-bolder'>YOUR RIGHT ANSWERS</ModalHeader>
        <ModalBody>
          <Table responsive>
            <thead>
              <tr>
                <th>
                  #
                </th>
                <th>
                  WORD
                </th>
                <th>
                  PART OF SPEECH
                </th>
                <th>
                  EXPLANATION
                </th>
              </tr>
            </thead>
            <tbody>
              {rightAnswer.map((item) => {

                return <tr>
                  <th scope='row'>

                  </th>
                  <td>
                    {item.name}
                  </td>
                  <td>
                    {item.partOfSpeech}
                  </td>
                  <td>
                    <ol>
                      {item.meaning.map((item) => {
                        return <li>
                          {item.value}
                          {item.example.map((item) => {
                            return <ul className='fst-italic'>
                              <li>{item}</li>
                            </ul>
                          })}
                        </li>
                      })}
                    </ol>
                  </td>
                </tr>;
              })}
            </tbody>
          </Table>
        </ModalBody>
      </Modal>
    </div>
  );
}

export default ResultTable;