import React from "react";
import Sidebar from './Sidebar';
import {
    BrowserRouter as Router,
    Switch,
    Route,
    Link, useRouteMatch,
} from "react-router-dom";

function AdminIndex() {
    let match = useRouteMatch();
    return(
        <div id="admin-index" className="admin">
            <Sidebar/>
            <div className="content"></div>
        </div>
    );
}

export default AdminIndex;