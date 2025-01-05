public class TestHandler {
    private Tester tester;
    
    public TestHandler() {
        this.tester = new Tester();
    }

    public int getNumberOfTests(TesterQuestionEnum question){
        switch (question) {
            case USER_FOLLOWS:
                return 8;
        
            case USER_ADD_FOLLOWEE:
                return 5;

            case USER_REMOVE_FOLLOWEE:
                return 6;
            
            case USER_COUNT_MUTUAL:
                return 10;
            
            case USER_IS_FRIEND_OF:
                return 6;
            
            case NETWORK_GET_USER:
                return 7;

            case NETWORK_ADD_USER:
                return 8;
            
            case NETWORK_ADD_FOLLOWEE:
                return 9;

            case NETWORK_RECOMMEND_WHO_TO_FOLLOW:
                return 3;
            
            case NETWORK_MOST_POPULAR_USER:
                return 10;

            case NETWORK_TO_STRING:
                return 4;
            default:
                break;
        }
        return 0;
    }

    public boolean runTest(TesterQuestionEnum question, int testNumber){
        switch (question) {
            case USER_FOLLOWS:
                return followsTests(testNumber);
        
            case USER_ADD_FOLLOWEE:
                return addFolloweeTests(testNumber);

            case USER_REMOVE_FOLLOWEE:
                return removeFolloweeTests(testNumber);
            
            case USER_COUNT_MUTUAL:
                return countMutualTests(testNumber);
            
            case USER_IS_FRIEND_OF:
                return isFriendOfTests(testNumber);
            
            case NETWORK_GET_USER:
                return networkGetUserTests(testNumber);

            case NETWORK_ADD_USER:
                return networkAddUserTests(testNumber);

            case NETWORK_ADD_FOLLOWEE:
                return networkAddFolloweeTests(testNumber);
            
            case NETWORK_RECOMMEND_WHO_TO_FOLLOW:
                return networkRecommendWhoToFollowTests(testNumber);
            
            case NETWORK_MOST_POPULAR_USER:
                return networkMostPopularUserTests(testNumber);
            
            case NETWORK_TO_STRING:
                return networkToStringTests(testNumber);
            default:
                break;
        }
        return false;
    }

    public boolean runAllTests(TesterQuestionEnum question){
        int numberOfTests = getNumberOfTests(question);
        boolean passed = true;
        for (int i = 1; i <= numberOfTests; i++) {
            passed = runTest(question, i) && passed;
        }
        return passed;
    }

    public void mainTestUserFollow() {
        this.tester.reset(TesterQuestionEnum.USER_FOLLOWS);
        boolean passed = runAllTests(TesterQuestionEnum.USER_FOLLOWS);
        if (passed) {
            this.tester.updatePoints();
        }
        System.out.println(tester);
    }

    public boolean followsTests(int testNumber){
        switch (testNumber) {
            case 1:
                return followsTest1();
            case 2:
                return followsTest2();
            case 3:
                return followsTest3();
            case 4:
                return followsTest4();
            case 5:
                return followsTest5();
            case 6:
                return followsTest6();
            case 7:
                return followsTest7();
            case 8:
                return followsTest8();
            default:
                break;
        }
        return false;
    }

    public boolean followsTest1(){
        User alice = new User("Alice", true);
        String expected = "true";
        String actual = "";
        try {
            actual += alice.follows("Foo");
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Alice getting started = true, checks follows Foo", expected, actual);
    }
    public boolean followsTest2(){
        User alice = new User("Alice", true);
        String expected = "true";
        String actual = "";
        try {
            actual += alice.follows("Bar");
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Alice getting started = true, checks follows Bar", expected, actual);
    }

    public boolean followsTest3(){
        User alice = new User("Alice", true);
        String expected = "true";
        String actual = "";
        try {
            actual += alice.follows("baz");
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Alice getting started = true, checks follows baz", expected, actual);
    }

    public boolean followsTest4(){
        User alice = new User("Alice", true);
        String expected = "false";
        String actual = "";
        try {
            actual += alice.follows("Test");
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Alice getting started = true, checks follows Test", expected, actual);
    }

    public boolean followsTest5(){
        User alice = new User("Alice");
        String expected = "false";
        String actual = "";
        try {
            actual += alice.follows("Foo");
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Alice getting started = false, checks follows Foo", expected, actual);
    }

    public boolean followsTest6(){
        User alice = new User("Alice");
        String expected = "false";
        String actual = "";
        try {
            actual += alice.follows("Test");
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Alice getting started = false, checks follows Test", expected, actual);
    }

    public boolean followsTest7(){
        User alice = new User("Alice");
        String expected = "false";
        String actual = "";
        try {
            actual += alice.follows("Alice");
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Alice getting started = false, checks follows Alice", expected, actual);
    }

    public boolean followsTest8(){
        User alice = new User("Alice");
        String expected = "false";
        String actual = "";
        try {
            actual += alice.follows("alice");
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Alice getting started = false, checks follows alice", expected, actual);
    }

    public void mainAddFolloweeTest(){
        this.tester.reset(TesterQuestionEnum.USER_ADD_FOLLOWEE);
        boolean passed = runAllTests(TesterQuestionEnum.USER_ADD_FOLLOWEE);
        if (passed) {
            this.tester.updatePoints();
        }
        System.out.println(tester);
    }

    public boolean addFolloweeTests(int testNumber){
        switch (testNumber) {
            case 1:
                return addFolloweeTest1();
            case 2:
                return addFolloweeTest2();
            case 3:
                return addFolloweeTest3();
            case 4:
                return addFolloweeTest4();
            case 5:
                return addFolloweeTest5();
            default:
                break;
        }
        return false;
    }

    public boolean addFolloweeTest1(){
        User alice = new User("Alice");
        String expected = "true";
        String actual = "";
        try {
            actual += (alice.addFollowee("Foo") && alice.getfCount() == 1);
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Alice, getting started = false, try to add Followee Foo", expected, actual);
    }

    public boolean addFolloweeTest2(){
        User alice = new User("Alice");
        String expected = "true";
        String actual = "";
        try {
            actual += (alice.addFollowee("Foo") && alice.addFollowee("Bar") && alice.getfCount() == 2 && alice.follows("Foo") && alice.follows("Bar"));
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Alice, getting started = false, try to add Followee Foo and Bar", expected, actual);
    }

    public boolean addFolloweeTest3(){
        User alice = new User("Alice");
        String expected = "false";
        String actual = "";
        try {
            actual += (alice.addFollowee("Foo") && alice.addFollowee("Foo") && alice.getfCount() == 1 && alice.follows("Foo"));
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Alice, getting started = false, try to add Followee Foo twice", expected, actual);
    }

    public boolean addFolloweeTest4(){
        User alice = new User("Alice");
        String expected = "false";
        String actual = "";
        try {
            boolean result = true;
            for (int i = 0; i < 100; i++) {
                result = alice.addFollowee("User " + (i + 1)) && result;
            }
            actual += (result && alice.getfCount() == 10 && User.maxfCount == 10 && alice.getfFollows().length == 10);
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Alice, add 100 users, followee count is still 10", expected, actual);
    }

    public boolean addFolloweeTest5(){
        User alice = new User("Alice");
        String expected = "true";
        String actual = "";
        try {
            actual += (alice.addFollowee("Foo") && !alice.addFollowee("foo") && alice.getfCount() == 1 && alice.follows("Foo"));
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Alice, getting started = false, try to add Followee Foo and foo", expected, actual);
    }

    // Improved removeFollowee Tests
    public void mainRemoveFolloweeTest() {
        this.tester.reset(TesterQuestionEnum.USER_REMOVE_FOLLOWEE);
        boolean passed = runAllTests(TesterQuestionEnum.USER_REMOVE_FOLLOWEE);
        if (passed) {
            this.tester.updatePoints();
        }
        System.out.println(tester);
    }

    public boolean removeFolloweeTests(int testNumber) {
        switch (testNumber) {
            case 1:
                return removeFolloweeTest1();
            case 2:
                return removeFolloweeTest2();
            case 3:
                return removeFolloweeTest3();
            case 4:
                return removeFolloweeTest4();
            case 5:
                return removeFolloweeTest5();
            case 6:
                return removeFolloweeTest6();
            default:
                return false;
        }
    }

    public boolean removeFolloweeTest1() {
        User alice = new User("Alice");
        alice.addFollowee("Bob");
        String expected = "true";
        String actual = "";
        try {
            actual += (alice.removeFollowee("Bob") && alice.getfCount() == 0);
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Remove existing followee Bob and check fCount is updated", expected, actual);
    }

    public boolean removeFolloweeTest2() {
        User alice = new User("Alice");
        String expected = "false";
        String actual = "";
        try {
            actual += (alice.removeFollowee("Charlie") && alice.getfCount() == 0);
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Try to remove non-existing followee Charlie, fCount should remain unchanged", expected, actual);
    }

    public boolean removeFolloweeTest3() {
        User alice = new User("Alice");
        alice.addFollowee("Bob");
        alice.removeFollowee("Bob");
        String expected = "false";
        String actual = "";
        try {
            actual += alice.removeFollowee("Bob");
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Try to remove Bob again after removal", expected, actual);
    }

    public boolean removeFolloweeTest4() {
        User alice = new User("Alice");
        alice.addFollowee("Bob");
        alice.addFollowee("Charlie");
        String expected = "true";
        String actual = "";
        try {
            actual += (alice.removeFollowee("Charlie") && alice.getfCount() == 1 && alice.follows("Bob"));
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Remove one followee but keep another, check fCount is consistent", expected, actual);
    }

    public boolean removeFolloweeTest5() {
        User alice = new User("Alice");
        alice.addFollowee("Charlie");
        alice.removeFollowee("Charlie");
        alice.addFollowee("Charlie");
        String expected = "true";
        String actual = "";
        try {
            actual += (alice.follows("Charlie") && alice.getfCount() == 1);
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Re-add followee after removal and check fCount is updated correctly", expected, actual);
    }

    public boolean removeFolloweeTest6() {
        User alice = new User("Alice");
        String expected = "false";
        String actual = "";
        try {
            actual += alice.removeFollowee(null);
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Try to remove null followee, fCount should remain unchanged", expected, actual);
    }

    public void mainIsFriendOfTest() {
        this.tester.reset(TesterQuestionEnum.USER_IS_FRIEND_OF);
        boolean passed = runAllTests(TesterQuestionEnum.USER_IS_FRIEND_OF);
        if (passed) {
            this.tester.updatePoints();
        }
        System.out.println(tester);
    }

    // Improved isFriendOf Tests
    public boolean isFriendOfTests(int testNumber) {
        switch (testNumber) {
            case 1:
                return isFriendOfTest1();
            case 2:
                return isFriendOfTest2();
            case 3:
                return isFriendOfTest3();
            case 4:
                return isFriendOfTest4();
            case 5:
                return isFriendOfTest5();
            case 6:
                return isFriendOfTest6();
            default:
                return false;
        }
    }

    public boolean isFriendOfTest1() {
        User alice = new User("Alice");
        User bob = new User("Bob");
        alice.addFollowee("Bob");
        bob.addFollowee("Alice");
        String expected = "true";
        String actual = "";
        try {
            actual += alice.isFriendOf(bob);
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Mutual following establishes friendship", expected, actual);
    }

    public boolean isFriendOfTest2() {
        User alice = new User("Alice");
        User bob = new User("Bob");
        alice.addFollowee("Bob");
        String expected = "false";
        String actual = "";
        try {
            actual += alice.isFriendOf(bob);
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("One-way follow does not establish friendship", expected, actual);
    }

    public boolean isFriendOfTest3() {
        User alice = new User("Alice");
        User bob = new User("Bob");
        bob.addFollowee("Alice");
        String expected = "false";
        String actual = "";
        try {
            actual += alice.isFriendOf(bob);
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Reverse one-way follow does not establish friendship", expected, actual);
    }

    public boolean isFriendOfTest4() {
        User alice = new User("Alice");
        User bob = new User("Bob");
        String expected = "false";
        String actual = "";
        try {
            actual += alice.isFriendOf(bob);
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("No follow relationship does not establish friendship", expected, actual);
    }

    public boolean isFriendOfTest5() {
        User alice = new User("Alice");
        User bob = new User("Bob");
        alice.addFollowee("Charlie");
        String expected = "false";
        String actual = "";
        try {
            actual += alice.isFriendOf(bob);
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Friendship is specific to the pair", expected, actual);
    }

    public boolean isFriendOfTest6() {
        User alice = new User("Alice");
        User bob = new User("Bob");
        alice.addFollowee(bob.getName());
        bob.addFollowee(alice.getName());
        bob.removeFollowee(alice.getName());
        String expected = "false";
        String actual = "";
        try {
            actual += alice.isFriendOf(bob);
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Friendship test with removed user", expected, actual);
    }

    public void mainCountMutualTest() {
        this.tester.reset(TesterQuestionEnum.USER_COUNT_MUTUAL);
        boolean passed = runAllTests(TesterQuestionEnum.USER_COUNT_MUTUAL);
        if (passed) {
            this.tester.updatePoints();
        }
        System.out.println(tester);
    }
    public boolean countMutualTests(int testNumber) {
        switch (testNumber) {
            case 1:
                return countMutualTest1();
            case 2:
                return countMutualTest2();
            case 3:
                return countMutualTest3();
            case 4:
                return countMutualTest4();
            case 5:
                return countMutualTest5();
            case 6:
                return countMutualTest6();
            case 7:
                return countMutualTest7();
            case 8:
                return countMutualTest8();
            case 9:
                return countMutualTest9();
            case 10:
                return countMutualTest10();
            default:
                return false;
        }
    }
    public boolean countMutualTest1() {
        User alice = new User("Alice");
        User bob = new User("Bob");
        alice.addFollowee("Charlie");
        bob.addFollowee("Charlie");
        String expected = "1";
        String actual = "";
        try {
            actual += alice.countMutual(bob);
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("One mutual follow between Alice and Bob", expected, actual);
    }
    public boolean countMutualTest2() {
        User alice = new User("Alice");
        User bob = new User("Bob");
        alice.addFollowee("Charlie");
        bob.addFollowee("David");
        String expected = "0";
        String actual = "";
        try {
            actual += alice.countMutual(bob);
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("No mutual follows between Alice and Bob", expected, actual);
    }
    public boolean countMutualTest3() {
        User alice = new User("Alice");
        User bob = new User("Bob");
        alice.addFollowee("Charlie");
        alice.addFollowee("David");
        bob.addFollowee("Charlie");
        bob.addFollowee("David");
        String expected = "2";
        String actual = "";
        try {
            actual += alice.countMutual(bob);
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Two mutual follows between Alice and Bob", expected, actual);
    }

    public boolean countMutualTest4() {
        User alice = new User("Alice");
        User bob = new User("Bob");
        bob.addFollowee("Charlie");
        bob.addFollowee("David");
        String expected = "0";
        String actual = "";
        try {
            actual += alice.countMutual(bob);
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Alice has no follows, mutual count is zero", expected, actual);
    }
    public boolean countMutualTest5() {
        User alice = new User("Alice");
        User bob = new User("Bob");
        alice.addFollowee("Charlie");
        alice.addFollowee("David");
        String expected = "0";
        String actual = "";
        try {
            actual += alice.countMutual(bob);
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Bob has no follows, mutual count is zero", expected, actual);
    }
    public boolean countMutualTest6() {
        User alice = new User("Alice");
        User bob = new User("Bob");
        String expected = "0";
        String actual = "";
        try {
            actual += alice.countMutual(bob);
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Both users have empty follow lists, mutual count is zero", expected, actual);
    }
    public boolean countMutualTest7() {
        User alice = new User("Alice");
        User bob = new User("Bob");
        for (int i = 1; i <= 100; i++) {
            alice.addFollowee("User" + i);
            bob.addFollowee("User" + i);
        }
        String expected = "10";
        String actual = "";
        try {
            actual += alice.countMutual(bob);
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Large overlapping follow lists", expected, actual);
    }
    public boolean countMutualTest8() {
        User alice = new User("Alice");
        User bob = new User("Bob");
        for (int i = 1; i <= 7; i++) {
            alice.addFollowee("User" + i);
        }
        for (int i = 3; i <= 10; i++) {
            bob.addFollowee("User" + i);
        }
        String expected = "5";
        String actual = "";
        try {
            actual += alice.countMutual(bob);
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Partially overlapping follow lists", expected, actual);
    }
    public boolean countMutualTest9() {
        User alice = new User("Alice");
        User bob = new User("Bob");
        alice.addFollowee("Charlie");
        alice.addFollowee("Charlie"); 
        bob.addFollowee("Charlie");
        String expected = "1";
        String actual = "";
        try {
            actual += alice.countMutual(bob);
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Mutual follows with duplicates in one list", expected, actual);
    }
    public boolean countMutualTest10() {
        User alice = new User("Alice");
        alice.addFollowee("Charlie");
        alice.addFollowee("David");
        String expected = "" + alice.getfCount();
        String actual = "";
        try {
            actual += alice.countMutual(alice);
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Mutual count when comparing user to themselves", expected, actual);
    }


    public boolean networkGetUserTests(int testNumber) {
        switch (testNumber) {
            case 1: return getUserTest1();
            case 2: return getUserTest2();
            case 3: return getUserTest3();
            case 4: return getUserTest4();
            case 5: return getUserTest5();
            case 6: return getUserTest6();
            case 7: return getUserTest7();
            default: return false;
        }
    }
    public void mainNetworkGetUserTest() {
        this.tester.reset(TesterQuestionEnum.NETWORK_GET_USER);
        boolean passed = runAllTests(TesterQuestionEnum.NETWORK_GET_USER);
        if (passed) {
            this.tester.updatePoints();
        }
        System.out.println(tester);
    }

    public boolean getUserTest1() {
        Network network = new Network(5, true);
        String expected = "Foo";
        String actual = "";
        try {
            actual += network.getUser("Foo").getName();
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Get predefined user Foo", expected, actual);
    }
    
    public boolean getUserTest2() {
        Network network = new Network(5, true);
        String expected = "Bar";
        String actual = "";
        try {
            actual += network.getUser("Bar").getName();
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Get predefined user Bar", expected, actual);
    }
    
    public boolean getUserTest3() {
        Network network = new Network(5, true);
        String expected = "null";
        String actual = "";
        try {
            actual += network.getUser("NonExistent");
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Get non-existing user in predefined network", expected, actual);
    }
    
    public boolean getUserTest4() {
        Network network = new Network(5, true);
        String expected = "Baz";
        String actual = "";
        try {
            actual += network.getUser("Baz").getName();
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Get predefined user Baz", expected, actual);
    }
    
    public boolean getUserTest5() {
        Network network = new Network(5, true);
        String expected = TesterMessagesEnum.ERROR + " " + TesterMessagesEnum.EXPECTED;
        String actual = "";
        try {
            actual += network.getUser(null).getName();
        } catch (NullPointerException e) {
            actual = TesterMessagesEnum.ERROR + " " + TesterMessagesEnum.EXPECTED;
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Get user with null name in predefined network", expected, actual);
    }
    
    public boolean getUserTest6() {
        Network network = new Network(5, true);
        String expected = "Baz";
        String actual = "";
        try {
            actual += network.getUser("baz").getName();
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Case-insensitive search for user Baz using 'baz'", expected, actual);
    }

    public boolean getUserTest7() {
        Network network = new Network(5);
        String expected = "null";
        String actual = "";
        try {
            actual += network.getUser("Foo");
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Case-insensitive search for user Baz using 'baz'", expected, actual);
    }
    
    public void mainNetworkAddUserTest() {
        this.tester.reset(TesterQuestionEnum.NETWORK_ADD_USER);
        boolean passed = runAllTests(TesterQuestionEnum.NETWORK_ADD_USER);
        if (passed) {
            this.tester.updatePoints();
        }
        System.out.println(tester);
    }
    
    public boolean networkAddUserTests(int testNumber) {
        switch (testNumber) {
            case 1: return addUserTest1();
            case 2: return addUserTest2();
            case 3: return addUserTest3();
            case 4: return addUserTest4();
            case 5: return addUserTest5();
            case 6: return addUserTest6();
            case 7: return addUserTest7();
            case 8: return addUserTest8();
            default: return false;
        }
    }
    public boolean addUserTest1() {
        Network network = new Network(5);
        String expected = "true";
        String actual = "";
        try {
            actual += network.addUser("Alice") && (network.getUserCount() == 1);
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Add a new user Alice and verify userCount", expected, actual);
    }
    
    public boolean addUserTest2() {
        Network network = new Network(5);
        network.addUser("Bob");
        String expected = "false";
        String actual = "";
        try {
            actual += network.addUser("Bob") && (network.getUserCount() == 1);
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Add an existing user Bob and verify userCount", expected, actual);
    }
    
    public boolean addUserTest3() {
        Network network = new Network(2);
        network.addUser("Charlie");
        network.addUser("Dave");
        String expected = "false";
        String actual = "";
        try {
            actual += network.addUser("Eve") && (network.getUserCount() == 2);
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Add user to a full network and verify userCount", expected, actual);
    }
    
    public boolean addUserTest4() {
        Network network = new Network(5);
        String expected = "true";
        String actual = "";
        try {
            actual += network.addUser("Foo") && (network.getUserCount() == 1);
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Add a new user Foo and verify userCount", expected, actual);
    }
    
    public boolean addUserTest5() {
        Network network = new Network(5, true);
        String expected = "false";
        String actual = "";
        try {
            actual += network.addUser("Foo") && (network.getUserCount() == 3);
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Add a user already in the predefined network Foo and verify userCount", expected, actual);
    }
    
    public boolean addUserTest6() {
        Network network = new Network(5);
        String expected = "false";
        String actual = "";
        try {
            actual += network.addUser(null) && (network.getUserCount() == 0);
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Add a null user and verify userCount", expected, actual);
    }
    
    public boolean addUserTest7() {
        Network network = new Network(5);
        network.addUser("User1");
        network.addUser("User2");
        network.addUser("User3");
        network.addUser("User4");
        network.addUser("User5");
        String expected = "false";
        String actual = "";
        try {
            actual += network.addUser("User6") && (network.getUserCount() == 5);
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Add a valid new user User6 to a full network and verify userCount", expected, actual);
    }
    
    public boolean addUserTest8() {
        Network network = new Network(5, true);
        String expected = "true";
        String actual = "";
        try {
            actual += network.addUser("NewUser") && (network.getUserCount() == 4);
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Add a new user NewUser to a predefined network and verify userCount", expected, actual);
    }

    public void mainNetworkAddFolloweeTest() {
        this.tester.reset(TesterQuestionEnum.NETWORK_ADD_FOLLOWEE);
        boolean passed = runAllTests(TesterQuestionEnum.NETWORK_ADD_FOLLOWEE);
        if (passed) {
            this.tester.updatePoints();
        }
        System.out.println(tester);
    }
    
    public boolean networkAddFolloweeTests(int testNumber) {
        switch (testNumber) {
            case 1: return networkAddFolloweeTest1();
            case 2: return networkAddFolloweeTest2();
            case 3: return networkAddFolloweeTest3();
            case 4: return networkAddFolloweeTest4();
            case 5: return networkAddFolloweeTest5();
            case 6: return networkAddFolloweeTest6();
            case 7: return networkAddFolloweeTest7();
            case 8: return networkAddFolloweeTest8();
            case 9: return networkAddFolloweeTest9();
            default: return false;
        }
    }
    
    public boolean networkAddFolloweeTest1() {
        Network network = new Network(5, true);
        String expected = "true";
        String actual = "";
        try {
            actual += network.addFollowee("Foo", "Bar");
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Add a followee Bar to user Foo", expected, actual);
    }
    
    public boolean networkAddFolloweeTest2() {
        Network network = new Network(5, true);
        String expected = "false";
        String actual = "";
        try {
            actual += network.addFollowee("Foo", "NonExistent");
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Add a followee NonExistent to user Foo", expected, actual);
    }
    
    public boolean networkAddFolloweeTest3() {
        Network network = new Network(5, true);
        String expected = "false";
        String actual = "";
        try {
            actual += network.addFollowee("NonExistent", "Bar");
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Add a followee Bar to non-existent user NonExistent", expected, actual);
    }
    
    public boolean networkAddFolloweeTest4() {
        Network network = new Network(5, true);
        network.addFollowee("Foo", "Bar");
        String expected = "false";
        String actual = "";
        try {
            actual += network.addFollowee("Foo", "Bar");
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Add an already-followed user Bar to Foo", expected, actual);
    }
    
    public boolean networkAddFolloweeTest5() {
        Network network = new Network(5, true);
        String expected = "false";
        String actual = "";
        try {
            actual += network.addFollowee("Baz", "Baz");
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Add a user Baz as a followee to itself", expected, actual);
    }
    
    public boolean networkAddFolloweeTest6() {
        Network network = new Network(5, true);
        String expected = "false";
        String actual = "";
        try {
            actual += network.addFollowee(null, "Bar");
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Add a followee Bar to a null user", expected, actual);
    }
    
    public boolean networkAddFolloweeTest7() {
        Network network = new Network(5, true);
        String expected = "false";
        String actual = "";
        try {
            actual += network.addFollowee("Foo", null);
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Add a null followee to user Foo", expected, actual);
    }
    
    public boolean networkAddFolloweeTest8() {
        Network network = new Network(5);
        network.addUser("Alice");
        network.addUser("Bob");
        String expected = "true";
        String actual = "";
        try {
            actual += network.addFollowee("Alice", "Bob");
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Add a valid followee Bob to user Alice", expected, actual);
    }
    
    public boolean networkAddFolloweeTest9() {
        Network network = new Network(5, true);
        network.addFollowee("Foo", "Bar");
        String expected = "true";
        String actual = "";
        try {
            actual += network.getUser("Foo").follows("Bar");
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Verify user Foo follows Bar after adding followee", expected, actual);
    }
    
    public void mainNetworkRecommendWhoToFollowTest() {
        this.tester.reset(TesterQuestionEnum.NETWORK_RECOMMEND_WHO_TO_FOLLOW);
        boolean passed = runAllTests(TesterQuestionEnum.NETWORK_RECOMMEND_WHO_TO_FOLLOW);
        if (passed) {
            this.tester.updatePoints();
        }
        System.out.println(tester);
    }
    
    public boolean networkRecommendWhoToFollowTests(int testNumber) {
        switch (testNumber) {
            case 1: return recommendWhoToFollowTest1();
            case 2: return recommendWhoToFollowTest2();
            case 3: return recommendWhoToFollowTest3();
            default: return false;
        }
    }
    
    public boolean recommendWhoToFollowTest1() {
        Network network = new Network(10);
        network.addUser("Alice");
        network.addUser("Bob");
        network.addUser("Charlie");
        network.addUser("Dave");
        network.addUser("Eve");
    
        network.addFollowee("Alice", "Bob");
        network.addFollowee("Alice", "Dave");
        network.addFollowee("Dave", "Charlie");
        network.addFollowee("Bob", "Charlie");
        network.addFollowee("Charlie", "Dave");
        network.addFollowee("Dave", "Eve");
        
        String expected = "Charlie";
        String actual = "";
        try {
            actual += network.recommendWhoToFollow("Alice");
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Recommend Charlie for Alice in a transitive follow scenario", expected, actual);
    }
    
    public boolean recommendWhoToFollowTest2() {
        Network network = new Network(10);
        network.addUser("Alice");
        network.addUser("Bob");
        network.addUser("Charlie");
        network.addUser("Dave");
        network.addUser("Eve");
        network.addUser("Frank");
    
        network.addFollowee("Alice", "Bob");
        network.addFollowee("Bob", "Charlie");
        network.addFollowee("Charlie", "Dave");
        network.addFollowee("Eve", "Charlie");
        network.addFollowee("Frank", "Charlie");
        network.addFollowee("Alice", "Frank");
        network.addFollowee("Frank", "Bob");
    
        String expected = "Bob";
        String actual = "";
        try {
            actual += network.recommendWhoToFollow("Eve");
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Recommend Bob to Eve via Charlie", expected, actual);
    }
    
    public boolean recommendWhoToFollowTest3() {
        Network network = new Network(15);
        network.addUser("Alice");
        network.addUser("Bob");
        network.addUser("Charlie");
        network.addUser("Dave");
        network.addUser("Eve");
        network.addUser("Frank");
        network.addUser("Grace");
        network.addUser("Hank");
    
        network.addFollowee("Alice", "Frank");
        network.addFollowee("Bob", "Charlie");
        network.addFollowee("Charlie", "Dave");
        network.addFollowee("Dave", "Eve");
        network.addFollowee("Eve", "Frank");
        network.addFollowee("Grace", "Eve");
        network.addFollowee("Hank", "Eve");
        network.addFollowee("Bob", "Dave");
        network.addFollowee("Charlie", "Eve");
    
        String expected = "Eve";
        String actual = "";
        try {
            actual += network.recommendWhoToFollow("Alice");
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }

        return this.tester.test("Recommend Eve to Alice", expected, actual);
    }
    

    public void mainNetworkMostPopularUserTest() {
        this.tester.reset(TesterQuestionEnum.NETWORK_MOST_POPULAR_USER);
        boolean passed = runAllTests(TesterQuestionEnum.NETWORK_MOST_POPULAR_USER);
        if (passed) {
            this.tester.updatePoints();
        }
        System.out.println(tester);
    }

    public boolean networkMostPopularUserTests(int testNumber) {
        switch (testNumber) {
            case 1: return mostPopularUserTest1();
            case 2: return mostPopularUserTest2();
            case 3: return mostPopularUserTest3();
            case 4: return mostPopularUserTest4();
            case 5: return mostPopularUserTest5();
            case 6: return mostPopularUserTest6();
            case 7: return mostPopularUserTest7();
            case 8: return mostPopularUserTest8();
            case 9: return mostPopularUserTest9();
            case 10: return mostPopularUserTest10();
            default: return false;
        }
    }
    
    public boolean mostPopularUserTest1() {
        Network network = new Network(5);
        network.addUser("Alice");
        network.addUser("Bob");
        network.addFollowee("Bob", "Alice");
        String expected = "Alice";
        String actual = "";
        try {
            actual += network.mostPopularUser();
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Most popular user is Alice with one follower", expected, actual);
    }
    
    public boolean mostPopularUserTest2() {
        Network network = new Network(5);
        String expected = "null";
        String actual = "";
        try {
            actual += network.mostPopularUser();
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Most popular user in an empty network is null", expected, actual);
    }
    
    public boolean mostPopularUserTest3() {
        Network network = new Network(5);
        network.addUser("Alice");
        network.addUser("Bob");
        network.addUser("Charlie");
        network.addFollowee("Bob", "Alice");
        network.addFollowee("Charlie", "Alice");
        String expected = "Alice";
        String actual = "";
        try {
            actual += network.mostPopularUser();
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Most popular user is Alice with two followers", expected, actual);
    }
    
    public boolean mostPopularUserTest4() {
        Network network = new Network(5);
        network.addUser("Alice");
        network.addUser("Bob");
        network.addUser("Charlie");
        network.addFollowee("Alice", "Bob");
        network.addFollowee("Charlie", "Bob");
        String expected = "Bob";
        String actual = "";
        try {
            actual += network.mostPopularUser();
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Most popular user is Bob with two followers", expected, actual);
    }
    
    public boolean mostPopularUserTest5() {
        Network network = new Network(5);
        network.addUser("Alice");
        network.addUser("Bob");
        network.addUser("Charlie");
        network.addUser("Dave");
        network.addFollowee("Alice", "Bob");
        network.addFollowee("Charlie", "Dave");
        String expected = "Bob";
        String actual = "";
        try {
            actual += network.mostPopularUser();
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Most popular user is Bob when multiple users have one follower", expected, actual);
    }
    
    public boolean mostPopularUserTest6() {
        Network network = new Network(5);
        network.addUser("Alice");
        network.addUser("Bob");
        network.addFollowee("Bob", "Alice");
        network.addFollowee("Alice", "Bob");
        String expected = "Alice";
        String actual = "";
        try {
            actual += network.mostPopularUser();
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Most popular user is Alice when both users follow each other", expected, actual);
    }
    
    public boolean mostPopularUserTest7() {
        Network network = new Network(5);
        network.addUser("Alice");
        network.addUser("Bob");
        network.addUser("Charlie");
        network.addFollowee("Bob", "Charlie");
        network.addFollowee("Charlie", "Bob");
        network.addFollowee("Alice", "Bob");
        String expected = "Bob";
        String actual = "";
        try {
            actual += network.mostPopularUser();
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Most popular user is Bob with one follower but also follows another user", expected, actual);
    }
    
    public boolean mostPopularUserTest8() {
        Network network = new Network(5);
        network.addUser("Alice");
        network.addUser("Bob");
        network.addFollowee("Alice", "Bob");
        String expected = "Bob";
        String actual = "";
        try {
            actual += network.mostPopularUser();
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Most popular user is Bob with a single follower Alice", expected, actual);
    }
    
    public boolean mostPopularUserTest9() {
        Network network = new Network(5);
        network.addUser("Alice");
        network.addUser("Bob");
        network.addUser("Charlie");
        network.addUser("Dave");
        network.addFollowee("Alice", "Charlie");
        network.addFollowee("Bob", "Charlie");
        network.addFollowee("Dave", "Charlie");
        String expected = "Charlie";
        String actual = "";
        try {
            actual += network.mostPopularUser();
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Most popular user is Charlie with three followers", expected, actual);
    }
    
    public boolean mostPopularUserTest10() {
        Network network = new Network(5);
        network.addUser("Alice");
        network.addUser("Bob");
        network.addFollowee("Alice", "Bob");
        network.addFollowee("Bob", "Alice");
        String expected = "Alice";
        String actual = "";
        try {
            actual += network.mostPopularUser();
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Most popular user is Alice in a cyclic follow relationship", expected, actual);
    }
    
    public void mainNetworkToStringTest() {
        this.tester.reset(TesterQuestionEnum.NETWORK_TO_STRING);
        boolean passed = runAllTests(TesterQuestionEnum.NETWORK_TO_STRING);
        if (passed) {
            this.tester.updatePoints();
        }
        System.out.println(tester);
    }
    
    public boolean networkToStringTests(int testNumber) {
        switch (testNumber) {
            case 1: return toStringTest1();
            case 2: return toStringTest2();
            case 3: return toStringTest3();
            case 4: return toStringTest4();
            default: return false;
        }
    }
    
    public boolean toStringTest1() {
        Network network = new Network(5);
        String expected = "Network:";
        String actual = "";
        try {
            actual += network.toString();
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Empty network toString", expected, actual);
    }
    
    public boolean toStringTest2() {
        Network network = new Network(5, true);
        String expected = "Network:\nFoo -> \nBar -> \nBaz -> ";
        String actual = "";
        try {
            actual += network.toString();
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Predefined network toString with no followees", expected, actual);
    }
    
    public boolean toStringTest3() {
        Network network = new Network(5, true);
        network.addFollowee("Foo", "Bar");
        network.addFollowee("Baz", "Foo");
        String expected = "Network:\nFoo -> Bar \nBar -> \nBaz -> Foo ";
        String actual = "";
        try {
            actual += network.toString();
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Predefined network with follow relationships", expected, actual);
    }
    
    public boolean toStringTest4() {
        Network network = new Network(5);
        network.addUser("Alice");
        network.addUser("Bob");
        network.addFollowee("Alice", "Bob");
        String expected = "Network:\nAlice -> Bob \nBob -> ";
        String actual = "";
        try {
            actual += network.toString();
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Network with added users and follow relationships", expected, actual);
    }

    public void conclusion() {
        this.tester.conclusion();
    }

    public void questionDecider(TesterQuestionEnum question, String[] args) {
        switch (question) {
            case USER_FOLLOWS:
                this.mainTestUserFollow();
                break;
            case USER_ADD_FOLLOWEE:
                this.mainAddFolloweeTest();
                break;
            case USER_REMOVE_FOLLOWEE:
                this.mainRemoveFolloweeTest();
                break;
            case USER_COUNT_MUTUAL:
                this.mainCountMutualTest();
                break;
            case USER_IS_FRIEND_OF:
                this.mainIsFriendOfTest();
                break;
            case NETWORK_GET_USER:
                this.mainNetworkGetUserTest();
                break;
            case NETWORK_ADD_USER:
                this.mainNetworkAddUserTest();
                break;
            case NETWORK_ADD_FOLLOWEE:
                this.mainNetworkAddFolloweeTest();
                break;
            case NETWORK_RECOMMEND_WHO_TO_FOLLOW:
                this.mainNetworkRecommendWhoToFollowTest();
                break;
            case NETWORK_MOST_POPULAR_USER:
                this.mainNetworkMostPopularUserTest();
                break;
            case NETWORK_TO_STRING:
                this.mainNetworkToStringTest();
                break;
            default:
                System.out.println("Invalid Question");
        }
    }
}
