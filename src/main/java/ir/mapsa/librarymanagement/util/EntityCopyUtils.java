package ir.mapsa.librarymanagement.util;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.util.Arrays;
import java.util.Objects;

public class EntityCopyUtils {

    public static void copyNonNullProperties(Object source, Object target) {
        //Call method by extra information for list of null properties to ignore
        BeanUtils.copyProperties(source, target, getNullPropertyNames(source));
    }

    //Collect list of null properties
    private static String[] getNullPropertyNames(Object source) {

        final BeanWrapper srcWrapper = new BeanWrapperImpl(source);

        return Arrays.stream(srcWrapper.getPropertyDescriptors())
                .map(pd -> srcWrapper.getPropertyValue(pd.getName()) == null ? pd.getName() : null)
                .filter(Objects::nonNull)
                .toArray(String[]::new);
    }
}
