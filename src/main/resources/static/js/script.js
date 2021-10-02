'use strict'



const NAME = document.querySelector("#name");
const AUTHOR = document.querySelector("#author");
const YEARPUBLISHED = document.querySelector("#yearPublished");
const GENRE = document.querySelector("#genre");
const RATING = document.querySelector("#rating");
const DIV = document.querySelector("#responsefromdb");

let submitButton = document.querySelector("#btn");

const DELETEID = document.querySelector("#deleteID");
let delBTN= document.querySelector("delBtn");

const printToScreen = (msg) => {
    const P = document.createElement("p");
    const TEXT = document.createTextNode(msg);

    P.appendChild(TEXT);
    DIV.appendChild(P);

}

const createBook = (e) => {
    e.preventDefault();

    const NAME_VALUE = NAME.value;
    const AUTHOR_VALUE = AUTHOR.value;
    const YEARPUBLISHED_VALUE = YEARPUBLISHED.value;
    const GENRE_VALUE = GENRE.value;
    const RATING_VALUE = RATING.value;

   console.log(NAME_VALUE,AUTHOR_VALUE,YEARPUBLISHED_VALUE,GENRE_VALUE,RATING_VALUE);

   let data = {
       name: NAME_VALUE,
       author: AUTHOR_VALUE,
       yearPublished: YEARPUBLISHED_VALUE,
       genre: GENRE_VALUE,
       rating: RATING_VALUE,
   };

   axios.post("http://localhost:4321/books/create", data, {
       headers: {
           'Access-Control-Allow-Origin': '*',
       }})
        .then( (response) => printToScreen("Library Updated!"))
        .catch( (error) => console.error(error));
}

const readBook = () => {

    
}











const deleteBook = () => {
    const DELID = Number(DELETEID.value);

    axios.delete(`http://localhost:4321/books/delete/${DELID}`, {
        headers:{
            'Access-Control-Allow-Origin': '*'
        }})
    .then( (response) => printToScreen("Entry Deleted!"))
    .catch( (error) => printToScreen("Something went wrong!"));




}

submitButton.addEventListener('click',createBook);
delBTN.addEventListener('click',deleteBook);