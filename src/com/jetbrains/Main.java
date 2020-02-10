package com.jetbrains;
import org.apache.commons.lang.StringEscapeUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.*;

public class Main {

    public static void main(String[] args) {

            BufferedReader br = null;
            Reader r = new InputStreamReader(System.in);
            br = new BufferedReader(r);
            ArrayList<String> tokens = new ArrayList<String>();
            APIHelper apiManager = APIHelper.getInstance();

            String str = null;
            String escapedStr = null;
            String languageText = null;
            String versionIndex = null;

            try {
                System.out.println("Enter the inputs. After entering the source code , please write 'exit'");

                System.out.print("Enter language : ");
                languageText = br.readLine().toLowerCase();

                System.out.print("Enter versionIndex : ");
                versionIndex = br.readLine();

                System.out.println("Enter source code : ");


                do{
                    str = br.readLine();
                    escapedStr = StringEscapeUtils.escapeJava(str);
                    tokens.add(escapedStr);

                } while (!str.equalsIgnoreCase("exit"));
            } catch (IOException e) {
                e.printStackTrace();
            } finally{
                try{
                    if(br != null) br.close();
                }catch(Exception ex){}
            }


            tokens.remove(tokens.size()-1);

            ProgrammingLanguage language = new ProgrammingLanguage(languageText,versionIndex);
            SourceCode sourceCode = new SourceCode(tokens,language);

            apiManager.request(sourceCode);





    }


}
