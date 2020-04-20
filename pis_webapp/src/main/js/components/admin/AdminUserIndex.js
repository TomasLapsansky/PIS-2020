import React from "react";
import Sidebar from './Sidebar';

class AdminUserIndex extends React.Component {

    render() {
        return(
            <div id="admin-user-index" className="admin">
                <Sidebar/>
                <div className="user-index">
                    user list
                </div>
            </div>
        );
    }

}

export default AdminUserIndex;