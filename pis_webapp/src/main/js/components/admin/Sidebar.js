import React from "react";
import {Link} from "react-router-dom";


class Sidebar extends React.Component {

    render() {
        return(
            <aside>
                <ul>
                    <li>
                        <Link to="/admin/users">Používatelia</Link>
                    </li>
                    <li>Produkty</li>
                    <li>Nastavenia</li>
                </ul>
            </aside>
        );
    }

}

export default Sidebar;