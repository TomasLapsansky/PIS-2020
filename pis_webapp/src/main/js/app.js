const React = require('react');
const ReactDOM = require('react-dom');

class App extends React.Component { // <1>


    render() { // <3>
        return (
            <span>React is running correctly !</span>
        )
    }
}

ReactDOM.render(
<App />,
    document.getElementById('react')
)