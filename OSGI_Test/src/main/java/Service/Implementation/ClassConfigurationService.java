package Service.Implementation;


import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name = "Configuration")
public @interface ClassConfigurationService {
    @AttributeDefinition(name ="Min Marks", type = AttributeType.INTEGER )
    int Min_Marks() default 33;

    @AttributeDefinition(name ="Max Students", type = AttributeType.INTEGER)
    int Max_Students() default 10;



}
