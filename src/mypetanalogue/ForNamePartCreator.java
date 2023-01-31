package mypetanalogue;

import java.util.ArrayList;
import java.util.List;

public class ForNamePartCreator extends Creator{
    private static List<Class<? extends Part>> types = new ArrayList<>();

    private static String[] typeNames = {
            "mypetanalogue.BallJoint",
            "mypetanalogue.Arm",
            "mypetanalogue.FlyWheel",
            "mypetanalogue.SilentBlock",
            "mypetanalogue.TailLight"
    };

    @SuppressWarnings("unchecked")
    private static void loader(){
        try{
            for(String name : typeNames)
                types.add((Class<? extends Part>)Class.forName(name));
        }catch (ClassNotFoundException e){
            throw new RuntimeException(e);
        }
    }

    static {loader();}

    @Override
    public List<Class<? extends Part>> types() {
        return types;
    }
}
