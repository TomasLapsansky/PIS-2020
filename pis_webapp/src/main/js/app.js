import {getRouteMatch} from "./hooks/hooks";

const React = require('react');
const ReactDOM = require('react-dom');
import { Provider } from 'react-redux'
import store from './redux/store';
import {
    BrowserRouter as Router,
    Switch,
    Route,
    Link
} from "react-router-dom";
import AdminIndex from './components/admin/AdminIndex';
import AdminUserIndex from "./components/admin/AdminUserIndex";

class App extends React.Component { // <1>


    render() { // <3>
        return (
            <Provider store={store}>
                <Router>
                    <Switch>
                        <Route exact path="/admin/users/">
                            <AdminUserIndex/>
                        </Route>
                        <Route path="/admin">
                            <AdminIndex/>
                        </Route>
                        <Route exact path="/">
                            <span>React is running correctly !</span>
                            <Link to="/admin">Admin</Link>
                        </Route>
                    </Switch>
                </Router>
            </Provider>
        )
    }
}

ReactDOM.render(
<App/>,
    document.getElementById('react')
)