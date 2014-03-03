package glenn;

import static org.easymock.EasyMock.createMock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;


/**
 * Created by ycv6026 on 2/28/14.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({ProductService.class})
public class TestProductService {

    @Test
    public void testGetProducts() {
        
        ProductDao dao = createMock(ProductDao.class);

        ProductService p = new ProductServiceImpl();
        p.setProductDao(dao);

    }
}
