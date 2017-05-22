public final class Catalog{
    
    public static String[] listTopics =
    {"M1 Calculate Velocity",
     "M2",
     "M3",
     "etc"};

    public static void printTopics() {
        for (String s : listTopics) {
            System.out.println(s);
        }
    }
}
