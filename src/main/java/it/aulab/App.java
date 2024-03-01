package it.aulab;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import it.aulab.models.Product;
import it.aulab.models.Provider;
import it.aulab.repositories.ProductRepository;
import it.aulab.repositories.ProviderRepository;
import it.aulab.repositories.RepositoryInterface;

public class App
{
    public static void main( String[] args )
    {
        ApplicationContext context =
            new AnnotationConfigApplicationContext(AppConfig.class);
        RepositoryInterface<Product> productRepository =
            context.getBean(ProductRepository.class);
        Product product = productRepository.findById(1L);
        System.out.println(product.getName() + " : " + product.getPrice());
        RepositoryInterface<Provider> providerRepository =
            context.getBean(ProviderRepository.class);
        Provider provider = providerRepository.findById(1L);
        System.out.println(provider.getName());
    }
}
