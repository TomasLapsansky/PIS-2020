import React from "react";
import Header from "./partial/Header";
import Sidebar from "./partial/Sidebar";
import {clearCart, clearOrder, createOrder} from "../../redux/actions/frontendActions";
import AddressForm from "./partial/AddressForm";
import {connect} from "react-redux";
import {Redirect} from "react-router-dom";

class Checkout extends React.Component {

    constructor(props) {
        super(props);
        this.getProductThumbnail = this.getProductThumbnail.bind(this);
        this.handleOrderCreate = this.handleOrderCreate.bind(this);
        this.redirectToReferrer = false;
        const order = Object.assign({}, {
           address: null,
           city: null,
           code: null,
           note: null,
           userID : 2
        });
        this.props.createOrder(order);
    }

    static mapStateToProps = (state) => {
        return {
            order: state.order.order,
            cartItemList: state.userCart.cartItemList
        }
    }

    getTotals() {
        let subTotal = 0;
        this.props.cartItemList.map(item => {
            subTotal += item.price;
        });
        return subTotal;
    }

    getProductThumbnail(event, id) {
        event.preventDefault();
    }

    async handleOrderCreate(event) {
        event.preventDefault();

        await fetch('/api/admin/products/create', {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(this.props.order),
        }).then(
            response => {
                console.log(response);
            }
        );

        console.log(this.props.order);

        this.props.clearCart();
        this.props.clearOrder();

        this.redirectToReferrer = true;

        this.forceUpdate();

    }

    render() {
        if (this.redirectToReferrer) {
            return <Redirect to="/order-detail/1" />
        }
        return(
            <div>
                <Header/>
                <div id="main-content">
                    <div id="content-holder">
                        <Sidebar />
                        <div id="checkout">
                            <h2>Pokladňa</h2>
                            <div className="row no-gutters">
                                <div className="col-md-6">
                                    <ul>
                                        {this.props.cartItemList.map(item => {
                                            return(
                                                <li className="cart-item" key={item.id}>
                                                    <img src={ (e) => this.getProductThumbnail(e, item.id)} alt=""/>
                                                    <span>{item.name}</span>
                                                    <span>{item.price}</span>
                                                </li>
                                            )
                                        })}
                                    </ul>
                                    <span>Cena celkom: {this.getTotals()}</span>
                                </div>
                                <div className="col-md-6">
                                    <h3>Adresa doručenia</h3>
                                    <AddressForm handleSubmit={this.handleOrderCreate}/>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
        );
    }

}

export default connect(
    Checkout.mapStateToProps,
    { clearCart, createOrder, clearOrder }
)(Checkout)
