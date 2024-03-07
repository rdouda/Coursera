import Card from './components/Card';

function App() {
  function handleClick(){
    let randomNumber = Math.floor(Math.random() * 3) + 1;
    console.log(randomNumber);
    let userInput = prompt('type a number');
    alert(`Computer number:${randomNumber}, Your guess:${userInput}`);
  }
  return (
    <div className="App">
      <h1>Task: Add a button and handle a click event</h1>
      <button onClick={handleClick}>Guess the number between 1 and 3</button>
    </div>
  );
}

export default App;
