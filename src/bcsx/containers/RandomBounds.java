package bcsx.containers;

/**
 * @author l
 * @date 2020/11/19 14:24
 * @description
 *
 * 17.10.3 微基准测试的危险
 * Math.random()它产生的是0到1的值吗？包括 还是不包括1？
 * 用数学 术语表示，就是它是(0.1),[0,1],(0,1]还是[0,1)
 * 提示：方括号表示“包括”，而圆括号表示“不包括”
 */

import static bcsx.net.mindview.util.Print.*;

public class RandomBounds {
    static void usage(){
        print("Usage:");
        print("\tRandomBounds lower");
        print("\tRandomBounds upper");
        System.exit(1);
    }

    public static void main(String[] args){
        args = new String[1];
        args[0] = "lower";
        if (args.length != 1) usage();
        if (args[0].equals("lower")){
            while(Math.random() != 0.0)
                ; //Keep trying
            print("Produced 0.0!");
        }else if(args[0].equals("upper")){
            while(Math.random() != 1.0)
                ; // Keep trying
            print("Produced 1.0!");

        }else
            usage();
    }

}
