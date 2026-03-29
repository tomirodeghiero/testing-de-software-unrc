package assignment4_exercises;
// Introduction to Software Testing
// Authors: Paul Ammann & Jeff Offutt
// Chapter 7, page 141; chapter 9, page 256
// See PatternIndexTest.java, DataDrivenPatternIndexTest.java  for JUnit tests

public class PatternIndex{
   
  /**
    * Find index of pattern in subject string
    * 
    * @param subject String to search
    * @param pattern String to find
    * @return index (zero-based) of first occurrence of pattern in subject; -1 if not found
    * @throws NullPointerException if subject or pattern is null
   */
   public static int patternIndex (String subject, String pattern){
      final int NOTFOUND = -1;
      int  iSub = 0, rtnIndex = NOTFOUND;
      boolean isPat  = false;
      int subjectLen = subject.length();
      int patternLen = pattern.length();

      PatternIndexPathTracker.startInvocation(subject, pattern);
      PatternIndexPathTracker.hit("S");

      while (true){
         PatternIndexPathTracker.hit("W");
         if (!(isPat == false && iSub + patternLen - 1 < subjectLen)){
            break;
         }

         PatternIndexPathTracker.hit("I");
         if (subject.charAt(iSub) == pattern.charAt(0)){
            PatternIndexPathTracker.hit("M");
            rtnIndex = iSub; // Starting at zero
            isPat = true;

            boolean brokeForMismatch = false;
            for (int iPat = 1; iPat < patternLen; iPat ++){
               PatternIndexPathTracker.hit("FT");
               PatternIndexPathTracker.hit("IFM");
               if (subject.charAt(iSub + iPat) != pattern.charAt(iPat)){
                  PatternIndexPathTracker.hit("MIS");
                  rtnIndex = NOTFOUND;
                  isPat = false;
                  brokeForMismatch = true;
                  /* MB: isPat = true; */
                  break;  // out of for loop
               }
               PatternIndexPathTracker.hit("FI");
            }
            if (!brokeForMismatch){
               PatternIndexPathTracker.hit("FF");
            }
         }
         PatternIndexPathTracker.hit("INC");
         iSub ++;
      }
      PatternIndexPathTracker.hit("R");
      PatternIndexPathTracker.endInvocation(rtnIndex);

      return (rtnIndex);
   }
}
