package exemplu13;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

class DreptunghiBeanPostProcessor implements BeanPostProcessor
{
	@Override public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException 
	{
		System.out.println("Bean name after initialization:"+beanName);
		return bean;
	}
	@Override public Object postProcessBeforeInitialization(Object bean,String beanName) throws BeansException 
	{
		System.out.println("Bean name before initialization:"+beanName);
		return bean;
	}
}