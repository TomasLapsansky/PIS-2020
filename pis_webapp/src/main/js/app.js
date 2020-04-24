import AdminProductCreate from "./components/admin/product/AdminProductCreate";

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
import AdminUserIndex from "./components/admin/user/AdminUserIndex";
import AdminUserCreate from "./components/admin/user/AdminUserCreate";
import AdminUserEdit from "./components/admin/user/AdminUserEdit";
import AdminProductIndex from "./components/admin/product/AdminProductIndex";
import AdminProductEdit from "./components/admin/product/AdminProductEdit";


class App extends React.Component { // <1>


    render() { // <3>
        return (
            <Provider store={store}>
                <Router>
                    <Switch>
                        <Route exact path="/admin/users/edit/:id"
                               render = {props => <AdminUserEdit {...props} /> } />
                       <Route exact path="/admin/users/create/">
                            <AdminUserCreate />
                        </Route>
                        <Route exact path="/admin/users/">
                            <AdminUserIndex />
                        </Route>
                        <Route exact path="/admin/products/edit/:id"
                               render = {props => <AdminProductEdit {...props} /> } />
                        <Route exact path="/admin/products/create">
                            <AdminProductCreate />
                        </Route>
                        <Route exact path="/admin/products/">
                            <AdminProductIndex />
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