import React from "react";
import Sidebar from './Sidebar';

function AdminIndex() {
    return(
        <div id="admin-index" className="admin">
            <Sidebar/>
            <div className="content"></div>
        </div>
    );
}

export default AdminIndex;