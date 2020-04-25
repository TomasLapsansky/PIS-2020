import React from "react";
import Sidebar from "./partial/Sidebar";
import Header from "./partial/Header";
import {connect} from "react-redux";
import {loadProductList} from "../../redux/actions/adminActions";
import ProductList from "./partial/ProductList";

class LandingPage extends React.Component {

    static mapStateToProps = state => { return {productList: state.productList.products} }

    async componentDidMount() {
        const ProductList = await fetch('/api/categories/1/products');
        const body = await ProductList.json();
        this.props.loadProductList(body);
    }

    render() {
        return(
            <div>
                <Header />
                <div id="main-content">
                    <div id="content-holder">
                        <Sidebar />
                        <div id="landing-page" className="content-area">
                            <ProductList />
                        </div>
                    </div>
                </div>
            </div>
        );
    }


}

export default connect(
    LandingPage.mapStateToProps,
    { loadProductList }
)
(LandingPage);