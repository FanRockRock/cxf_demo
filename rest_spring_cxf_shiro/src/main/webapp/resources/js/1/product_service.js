var ProductService = function() {
    var BASE = '/ws/rest';
    return {
        retrieveAllProducts: function(callback) {
            $.ajax({
                type: 'get',
                url: BASE + '/products',
                success: function(productList) {
                    ProductView.renderProductTable(productList);
                    callback();
                }
            });
        },
        retrieveProductById: function(id) {
            $.ajax({
                type: 'get',
                url: BASE + '/product/' + id,
                success: function(product) {
                    var title = 'Edit Product';
                    ProductView.renderProductModal(title, product);
                }
            });
        },
        retrieveProductsByName: function(name) {
            $.ajax({
                type: 'post',
                url: BASE + '/products',
                data: {
                    name: name
                },
                contentType: 'application/x-www-form-urlencoded',
                success: function(productList) {
                    ProductView.renderProductTable(productList);
                }
            });
        },
        createProduct: function(product) {
            $.ajax({
                type: 'post',
                url: BASE + '/product',
                data: JSON.stringify(product),
                contentType: 'application/json',
                success: function(product) {
                    ProductView.insertProductRow(product);
                }
            });
        },
        updateProductById: function(id, product) {
            $.ajax({
                type: 'put',
                url: BASE + '/product/' + id,
                data: JSON.stringify(product),
                contentType: 'application/json',
                success: function(product) {
                    ProductView.updateProductRow(product);
                }
            });
        },
        deleteProductById: function(id) {
            $.ajax({
                type: 'delete',
                url: BASE + '/product/' + id,
                success: function() {
                    ProductView.deleteProductRow(id);
                }
            });
        }
    };
}();