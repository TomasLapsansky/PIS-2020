import React from "react";
import Sidebar from "./partial/Sidebar";
import Header from "./partial/Header";
import {connect} from "react-redux";
import {loadProductList} from "../../redux/actions/adminActions";
import Badge from "react-bootstrap/Badge";
import {Link} from "react-router-dom";

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
                            <div className="product-list">
                                {this.props.productList.map((product) => {
                                    return(
                                        <div className="product-box" key={product.id}>
                                            {product.primaryPhoto && <div className="img-holder"><img src={product.primaryPhoto.file} alt=""/></div>}
                                            {!product.primaryPhoto && <div className="img-placeholder"/>}
                                            <Link to={"/product/"+product.id}>
                                                {product.name}
                                            </Link>
                                            <span>{product.price}</span>
                                        </div>
                                    )
                                })}
                            </div>
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