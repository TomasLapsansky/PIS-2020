import React from "react";
import {connect} from "react-redux";
import {Link} from "react-router-dom";
import {addCartItem, clearCart} from "../../../redux/actions/frontendActions";

class Header extends React.Component {

    static mapStateToProps = state => {
        return {
            cartItemList: state.userCart.cartItemList
        }
    }

    async componentDidMount() {
        this.props.clearCart();
        const response = await fetch('/api/cartitems/'+2);
        const body = await response.json();
        body.map( item => {
            this.props.addCartItem(item);
        });
    }

    render() {
        return(
            <header>
                <Link to="/">
                    <img src="/data/logo.png" alt="shop-logo"/>
                </Link>
                <div className="cart-controls">
                    <Link to="/cart">
                        <i className="fas fa-shopping-cart"/>
                        <span>{this.props.cartItemList.length}</span>
                    </Link>
                </div>
            </header>
        );

    }

}

export default connect(
    Header.mapStateToProps,
    { clearCart, addCartItem }
)(Header);