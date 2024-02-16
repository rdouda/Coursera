import React, {useState} from 'react'

const Counter = (props) => {
    const [counter, setCounter] = useState(0);

    let incrementCounter = () => {
        setCounter(counter+1);
    }
    let colorStyle = {color:props['color'], fontSize:props['size']}
    return (
        <div style={colorStyle}>
            React Component
            <br></br>
            <button onClick={incrementCounter}>Click Me!</button>
            <br></br>
            {counter}
        </div>
    );
}

export default Counter;