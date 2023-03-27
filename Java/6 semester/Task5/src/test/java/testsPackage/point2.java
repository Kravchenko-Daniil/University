package testsPackage;

import org.junit.platform.suite.api.ExcludeTags;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import testsPackage.n1.point1;


@Suite
@SelectClasses({testsPackage.n1.point1.class})
@SelectPackages({"testsPackage"})
public class point2 {

}
