import React from "react";
import {Link} from "react-router-dom";
import { setactiveItem } from "../../redux/actions/adminActions";
import {connect} from "react-redux";
//import logo from "../../../resources/static/img/logo.png";


class Sidebar extends React.Component {

    static mapStateToProps = state => { return {sidebar: state.sidebar} }

    render() {
        return(
            <aside>
                <ul>
                    <li className={(this.props.activeItem === 0) ? 'active' : ''}>
                        <Link to="/admin/users">Používatelia</Link>
                    </li>
                    <li className={(this.props.activeItem === 1) ? 'active' : ''}>
                        <Link to="/admin/products">Produkty</Link>
                    </li>
                    <li className={(this.props.activeItem === 2) ? 'active' : ''}>
                        <Link to="/admin/categories">Kategórie</Link>
                    </li>
                    <li className={(this.props.activeItem === 3) ? 'active' : ''}>
                        <Link to="/admin/discounts">Zľavy</Link>
                    </li>
                    <li className={(this.props.activeItem === 4) ? 'active' : ''}>
                        <Link to="/admin/orders">Objednávky</Link>
                    </li>
                </ul>
            </aside>
        );
    }

}

export default connect(
    Sidebar.mapStateToProps,
    { setactiveItem }
)(Sidebar);