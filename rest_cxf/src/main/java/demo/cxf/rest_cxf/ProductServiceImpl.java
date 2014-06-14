package demo.cxf.rest_cxf;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService {

    private static final List<Product> PRODUCT_LIST = new ArrayList<Product>();

    static {
        PRODUCT_LIST.add(new Product(1, "iphone 5s", 5000));
        PRODUCT_LIST.add(new Product(2, "ipad mini", 2500));
    }

    public List<Product> retrieveAllProducts() {
        return PRODUCT_LIST;
    }

    public Product retrieveProductById(long id) {
        Product targetProduct = null;
        for (Product product : PRODUCT_LIST) {
            if (product.getId() == id) {
                targetProduct = product;
                break;
            }
        }
        return targetProduct;
    }

    public List<Product> retrieveProductsByName(String name) {
        List<Product> targetProductList = new ArrayList<Product>();
        for (Product product : PRODUCT_LIST) {
            if (product.getName().contains(name)) {
                targetProductList.add(product);
            }
        }
        return targetProductList;
    }

    public Product createProduct(Product product) {
        PRODUCT_LIST.add(product);
        return product;
    }

    public Product updateProductById(long id, Map<String, Object> fieldMap) {
        Product product = retrieveProductById(id);
        if (product != null) {
            try {
                for (Map.Entry<String, Object> fieldEntry : fieldMap.entrySet()) {
                    Field field = Product.class.getDeclaredField(fieldEntry.getKey());
                    field.setAccessible(true);
                    field.set(product, fieldEntry.getValue());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return product;
    }

    public List<Product> deleteProductById(long id) {
        Iterator<Product> productIterator = PRODUCT_LIST.iterator();
        while (productIterator.hasNext()) {
            Product product = productIterator.next();
            if (product.getId() == id) {
                productIterator.remove();
                break;
            }
        }
        return PRODUCT_LIST;
    }
}
