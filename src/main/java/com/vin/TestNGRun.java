package com.vin;

import org.testng.ITestNGListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import org.testng.TestNG;
import org.testng.xml.Parser;

import java.io.InputStream;

import java.util.ArrayList;
import java.util.List;


public class TestNGRun {

    /**
     *
     * @param args - list of command line arguements that will be set to Java property
     * @return  0 - All Passed
     *          1 - Failures Found in Run
     *          2 - Skips Found in Run
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

//        System.out.print(args.length);
        if(args.length>0)
        {

            DefineVariables defVar = new DefineVariables();
            defVar.setCMDArguements(args);
        }
        String xmlName = System.getProperty("suiteXmlFile");

        /*String username = System.getProperty("username");
        String password = System.getProperty("password");
        if (username == null || username == "") {
            throw new Exception("Username not received");
        } else {
            Configuration.getUserPassword(username);
        }

        if(password == null || password == "")
            throw new Exception("Password not received");*/



        TestNG runner = new TestNG();
        ITestNGListener tla = new TestListenerAdapter();
        runner.addListener(tla);


        //If Suite File is passed, execute it else execute individual Test
        if (xmlName != null) {
            runner.setXmlSuites(new TestNGRun().getSuites("testsuite/" + xmlName + ".xml"));
        } else {

            runner.setTestClasses(new Class[]{(Class.forName("com.vin.testscripts." + System.getProperty("test")))});
        }

        runner.run();
        List<ITestResult> passedTests = new ArrayList<ITestResult>();
        passedTests = ((TestListenerAdapter) tla).getPassedTests();
        System.out.println("*********** Passed Tests**************");
        for(ITestResult itr : passedTests)
        {
            System.out.println("Name: "+itr.getName()+"       Class: "+itr.getTestClass()+"       Method:  "+itr.getMethod());
        }


        if(runner.hasFailure())
            System.exit(1);
        else if(runner.hasSkip())
            System.exit(2);
        else
            System.exit(0);
    }

//    private List getSuites(String fileName) throws Exception {
//            runner.setTestClasses(new Class[]{(Class.forName("com.vin.testscripts." + System.getProperty("test").toString()))});
//
//        }
//
//        runner.run();
//        List<ITestResult> passedTests = new ArrayList<ITestResult>();
//        passedTests = ((TestListenerAdapter) tla).getPassedTests();
//        System.out.println("*********** Passed Tests**************");
//        for(ITestResult itr : passedTests)
//        {
//            System.out.println("Name: "+itr.getName()+"       Class: "+itr.getTestClass()+"       Method:  "+itr.getMethod());
//        }
//
//
//        if(runner.hasFailure())
//            System.exit(1);
//        else if(runner.hasSkip())
//            System.exit(2);
//        else
//            System.exit(0);
//    }

   private List getSuites(String fileName) throws Exception {

       ClassLoader cl = this.getClass().getClassLoader();
        InputStream is = cl.getResourceAsStream(fileName);

        if (is == null)
           throw new Exception("Unable to create inputstream for given file: " + fileName);

        Parser p = new Parser(is);
        List suites = p.parseToList();
        return suites;
    }
}
