package engine.database;

import java.util.HashMap;

public class Database {

        public static HashMap<Character, boolean[][]> getLetterDatabase() {
                HashMap<Character, boolean[][]> letterDatabase = new HashMap<>();

                letterDatabase = new HashMap<>();

                boolean[][] patternAMaj = {
                                { false, false, false, false, false, false, false, false, false, false },
                                { false, false, false, true, true, true, true, false, false, false },
                                { false, false, true, false, false, false, false, true, false, false },
                                { false, true, false, false, false, false, false, false, true, false },
                                { false, true, false, false, false, false, false, false, true, false },
                                { false, true, true, true, true, true, true, true, true, false },
                                { false, true, false, false, false, false, false, false, true, false },
                                { false, true, false, false, false, false, false, false, true, false },
                                { false, true, false, false, false, false, false, false, true, false },
                                { false, true, false, false, false, false, false, false, true, false }
                };
                letterDatabase.put('A', patternAMaj);

                boolean[][] patternBMaj = {
                                { false, false, true, true, true, true, true, false, false, false },
                                { false, false, true, false, false, false, false, true, false, false },
                                { false, false, true, false, false, false, false, true, false, false },
                                { false, false, true, false, false, false, false, true, false, false },
                                { false, false, true, true, true, true, true, false, false, false },
                                { false, false, true, false, false, false, false, true, false, false },
                                { false, false, true, false, false, false, false, true, false, false },
                                { false, false, true, false, false, false, false, true, false, false },
                                { false, false, true, true, true, true, true, false, false, false },
                                { false, false, false, false, false, false, false, false, false, false }
                };
                letterDatabase.put('B', patternBMaj);

                boolean[][] patternCMaj = {
                                { false, false, false, false, false, false, false, false, false, false },
                                { false, false, false, true, true, true, true, true, false, false },
                                { false, false, true, true, false, false, false, false, false, false },
                                { false, false, true, false, false, false, false, false, false, false },
                                { false, false, true, false, false, false, false, false, false, false },
                                { false, false, true, false, false, false, false, false, false, false },
                                { false, false, true, false, false, false, false, false, false, false },
                                { false, false, true, true, false, false, false, false, false, false },
                                { false, false, false, true, true, true, true, true, false, false },
                                { false, false, false, false, false, false, false, false, false, false }
                };
                letterDatabase.put('C', patternCMaj);

                boolean[][] patternDMaj = {
                                { false, false, false, false, false, false, false, false, false, false },
                                { false, false, true, true, true, true, true, false, false, false },
                                { false, false, true, false, false, false, false, true, false, false },
                                { false, false, true, false, false, false, false, false, true, false },
                                { false, false, true, false, false, false, false, false, true, false },
                                { false, false, true, false, false, false, false, false, true, false },
                                { false, false, true, false, false, false, false, false, true, false },
                                { false, false, true, false, false, false, false, true, false, false },
                                { false, false, true, true, true, true, true, false, false, false },
                                { false, false, false, false, false, false, false, false, false, false }
                };
                letterDatabase.put('D', patternDMaj);

                boolean[][] patternEMaj = {
                                { false, true, true, true, true, true, true, true, true, false },
                                { false, true, false, false, false, false, false, false, false, false },
                                { false, true, false, false, false, false, false, false, false, false },
                                { false, true, false, false, false, false, false, false, false, false },
                                { false, true, true, true, true, true, true, false, false, false },
                                { false, true, false, false, false, false, false, false, false, false },
                                { false, true, false, false, false, false, false, false, false, false },
                                { false, true, false, false, false, false, false, false, false, false },
                                { false, true, true, true, true, true, true, true, true, false },
                                { false, false, false, false, false, false, false, false, false, false },
                };
                letterDatabase.put('E', patternEMaj);

                boolean[][] patternFMaj = {
                                { false, true, true, true, true, true, true, false, false, false },
                                { false, true, false, false, false, false, false, false, false, false },
                                { false, true, false, false, false, false, false, false, false, false },
                                { false, true, false, false, false, false, false, false, false, false },
                                { false, true, true, true, true, false, false, false, false, false },
                                { false, true, false, false, false, false, false, false, false, false },
                                { false, true, false, false, false, false, false, false, false, false },
                                { false, true, false, false, false, false, false, false, false, false },
                                { false, true, false, false, false, false, false, false, false, false },
                                { false, false, false, false, false, false, false, false, false, false }
                };
                letterDatabase.put('F', patternFMaj);

                boolean[][] patternGMaj = {
                                { false, false, false, false, false, false, false, false, false, false },
                                { false, false, false, true, true, true, true, false, false, false },
                                { false, false, true, true, false, false, false, false, false, false },
                                { false, false, true, false, false, false, false, false, false, false },
                                { false, false, true, false, false, false, false, false, false, false },
                                { false, false, true, false, false, true, true, true, false, false },
                                { false, false, true, false, false, false, true, false, false, false },
                                { false, false, true, true, false, true, true, false, false, false },
                                { false, false, false, true, true, true, false, false, false, false },
                                { false, false, false, false, false, false, false, false, false, false }
                };
                letterDatabase.put('G', patternGMaj);

                boolean[][] patternHMaj = {
                                { false, true, false, false, false, false, false, false, true, false },
                                { false, true, false, false, false, false, false, false, true, false },
                                { false, true, false, false, false, false, false, false, true, false },
                                { false, true, false, false, false, false, false, false, true, false },
                                { false, true, true, true, true, true, true, true, true, false },
                                { false, true, false, false, false, false, false, false, true, false },
                                { false, true, false, false, false, false, false, false, true, false },
                                { false, true, false, false, false, false, false, false, true, false },
                                { false, true, false, false, false, false, false, false, true, false },
                                { false, false, false, false, false, false, false, false, false, false }
                };
                letterDatabase.put('H', patternHMaj);

                boolean[][] patternIMaj = {
                                { false, false, false, false, false, false, false, false, false, false },
                                { false, false, false, false, false, true, false, false, false, false },
                                { false, false, false, false, false, true, false, false, false, false },
                                { false, false, false, false, false, true, false, false, false, false },
                                { false, false, false, false, false, true, false, false, false, false },
                                { false, false, false, false, false, true, false, false, false, false },
                                { false, false, false, false, false, true, false, false, false, false },
                                { false, false, false, false, false, true, false, false, false, false },
                                { false, false, false, false, false, true, false, false, false, false },
                                { false, false, false, false, false, false, false, false, false, false }
                };
                letterDatabase.put('I', patternIMaj);

                boolean[][] patternJMaj = {
                                { false, false, false, false, false, false, false, false, false, false },
                                { false, false, false, true, true, true, true, true, true, true },
                                { false, false, false, false, false, false, true, false, false, false },
                                { false, false, false, false, false, false, true, false, false, false },
                                { false, false, false, false, false, false, true, false, false, false },
                                { false, false, false, false, false, false, true, false, false, false },
                                { false, false, true, false, false, false, true, false, false, false },
                                { false, false, true, true, false, false, true, false, false, false },
                                { false, false, false, true, true, true, true, false, false, false },
                                { false, false, false, false, false, false, false, false, false, false }
                };
                letterDatabase.put('J', patternJMaj);

                boolean[][] patternKMaj = {
                                { false, false, false, false, false, false, false, false, false, false },
                                { false, true, false, false, false, false, false, false, false, false },
                                { false, true, false, false, false, true, true, true, false, false },
                                { false, true, false, true, true, true, false, false, false, false },
                                { false, true, true, false, false, false, false, false, false, false },
                                { false, true, true, true, false, false, false, false, false, false },
                                { false, true, false, false, true, true, false, false, false, false },
                                { false, true, false, false, false, true, true, true, false, false },
                                { false, true, false, false, false, false, false, false, false, false },
                                { false, false, false, false, false, false, false, false, false, false }
                };
                letterDatabase.put('K', patternKMaj);

                boolean[][] patternLMaj = {
                                { false, false, false, false, false, false, false, false, false, false },
                                { false, true, false, false, false, false, false, false, false, false },
                                { false, true, false, false, false, false, false, false, false, false },
                                { false, true, false, false, false, false, false, false, false, false },
                                { false, true, false, false, false, false, false, false, false, false },
                                { false, true, false, false, false, false, false, false, false, false },
                                { false, true, false, false, false, false, false, false, false, false },
                                { false, true, false, false, false, false, false, false, false, false },
                                { false, true, true, true, true, true, true, false, false, false },
                                { false, false, false, false, false, false, false, false, false, false }
                };
                letterDatabase.put('L', patternLMaj);

                boolean[][] patternMMaj = {
                                { false, false, false, false, false, false, false, false, false, false },
                                { false, true, false, false, false, false, false, false, true, false },
                                { false, true, true, false, false, false, false, true, true, false },
                                { false, true, true, true, false, false, true, true, true, false },
                                { false, true, false, true, true, true, true, false, true, false },
                                { false, true, false, false, true, true, false, false, true, false },
                                { false, true, false, false, false, false, false, false, true, false },
                                { false, true, false, false, false, false, false, false, true, false },
                                { false, true, false, false, false, false, false, false, true, false },
                                { false, false, false, false, false, false, false, false, false, false }
                };
                letterDatabase.put('M', patternMMaj);

                boolean[][] patternNMaj = {
                                { false, false, false, false, false, false, false, false, false, false },
                                { false, true, true, false, false, false, false, false, true, false },
                                { false, true, true, true, false, false, false, false, true, false },
                                { false, true, false, true, true, false, false, false, true, false },
                                { false, true, false, false, true, true, false, false, true, false },
                                { false, true, false, false, false, true, true, false, true, false },
                                { false, true, false, false, false, false, true, true, true, false },
                                { false, true, false, false, false, false, false, true, true, false },
                                { false, false, false, false, false, false, false, false, false, false },
                                { false, false, false, false, false, false, false, false, false, false }
                };
                letterDatabase.put('N', patternNMaj);

                boolean[][] patternOMaj = {
                                { false, false, false, false, false, false, false, false, false, false },
                                { false, false, false, true, true, true, true, false, false, false },
                                { false, false, true, false, false, false, false, true, false, false },
                                { false, true, false, false, false, false, false, false, true, false },
                                { false, true, false, false, false, false, false, false, true, false },
                                { false, true, false, false, false, false, false, false, true, false },
                                { false, true, false, false, false, false, false, false, true, false },
                                { false, false, true, false, false, false, false, true, false, false },
                                { false, false, false, true, true, true, true, false, false, false },
                                { false, false, false, false, false, false, false, false, false, false }
                };
                letterDatabase.put('O', patternOMaj);

                boolean[][] patternPMaj = {
                                { false, false, false, false, true, true, true, false, false, false },
                                { false, false, false, true, false, false, false, true, false, false },
                                { false, false, false, true, false, false, false, false, true, false },
                                { false, false, false, true, false, false, false, false, true, false },
                                { false, false, false, true, false, false, false, false, true, false },
                                { false, false, false, true, false, false, true, true, false, false },
                                { false, false, false, true, true, true, false, false, false, false },
                                { false, false, false, true, false, false, false, false, false, false },
                                { false, false, false, true, false, false, false, false, false, false },
                                { false, false, false, true, false, false, false, false, false, false }
                };
                letterDatabase.put('P', patternPMaj);

                boolean[][] patternQMaj = {
                                { false, false, false, false, false, false, false, false, false, false },
                                { false, false, false, true, true, true, true, false, false, false },
                                { false, false, true, false, false, false, false, true, false, false },
                                { false, true, false, false, false, false, false, false, true, false },
                                { false, true, false, false, false, false, false, false, true, false },
                                { false, true, false, false, false, false, false, false, true, false },
                                { false, true, false, false, false, false, true, false, true, false },
                                { false, false, true, false, false, false, false, true, false, false },
                                { false, false, false, true, true, true, true, false, true, false },
                                { false, false, false, false, false, false, false, false, false, true }
                };
                letterDatabase.put('Q', patternQMaj);

                boolean[][] patternRMaj = {
                                { false, false, false, true, true, true, true, false, false, false },
                                { false, false, true, false, false, false, false, true, false, false },
                                { false, false, true, false, false, false, false, false, true, false },
                                { false, false, true, false, false, false, false, false, true, false },
                                { false, false, true, false, false, false, true, true, false, false },
                                { false, false, true, true, true, true, true, false, false, false },
                                { false, false, true, false, false, false, true, true, false, false },
                                { false, false, true, false, false, false, false, true, true, false },
                                { false, false, true, false, false, false, false, false, true, true },
                                { false, false, true, false, false, false, false, false, false, true }
                };
                letterDatabase.put('R', patternRMaj);

                boolean[][] patternSMaj = {
                                { false, true, true, true, true, true, true, true, false, false },
                                { true, true, false, false, false, false, false, false, false, false },
                                { true, false, false, false, false, false, false, false, false, false },
                                { true, false, false, false, false, false, false, false, false, false },
                                { false, true, true, true, false, false, false, false, false, false },
                                { false, false, false, false, true, true, true, true, false, false },
                                { false, false, false, false, false, false, false, true, true, false },
                                { false, false, false, false, false, false, false, false, true, false },
                                { false, false, false, false, false, false, false, true, false, false },
                                { true, true, true, true, true, true, true, true, false, false }
                };
                letterDatabase.put('S', patternSMaj);

                boolean[][] patternTMaj = {
                                { false, false, false, false, false, false, false, false, false, false },
                                { true, true, true, true, true, true, true, true, true, false },
                                { false, false, false, false, false, true, false, false, false, false },
                                { false, false, false, false, false, true, false, false, false, false },
                                { false, false, false, false, false, true, false, false, false, false },
                                { false, false, false, false, false, true, false, false, false, false },
                                { false, false, false, false, false, true, false, false, false, false },
                                { false, false, false, false, false, true, false, false, false, false },
                                { false, false, false, false, false, true, false, false, false, false },
                                { false, false, false, false, false, true, false, false, false, false }
                };
                letterDatabase.put('T', patternTMaj);

                boolean[][] patternUMaj = {
                                { false, false, false, false, false, false, false, false, false, false },
                                { false, true, false, false, false, false, false, false, true, false },
                                { false, true, false, false, false, false, false, false, true, false },
                                { false, true, false, false, false, false, false, false, true, false },
                                { false, true, false, false, false, false, false, false, true, false },
                                { false, true, false, false, false, false, false, false, true, false },
                                { false, true, false, false, false, false, false, false, true, false },
                                { false, true, false, false, false, false, false, false, true, false },
                                { false, true, false, false, false, false, false, false, true, false },
                                { false, true, true, true, true, true, true, true, true, false }
                };
                letterDatabase.put('U', patternUMaj);

                boolean[][] patternVMaj = {
                                { false, false, false, false, false, false, false, false, false, false },
                                { true, false, false, false, false, false, false, false, false, true },
                                { true, true, false, false, false, false, false, false, true, true },
                                { false, true, false, false, false, false, false, false, true, false },
                                { false, true, true, false, false, false, false, true, true, false },
                                { false, false, true, false, false, false, false, true, false, false },
                                { false, false, true, true, false, false, true, true, false, false },
                                { false, false, false, true, true, true, true, false, false, false },
                                { false, false, false, false, true, true, false, false, false, false },
                                { false, false, false, false, true, true, false, false, false, false }
                };
                letterDatabase.put('V', patternVMaj);

                boolean[][] patternWMaj = {
                                { false, false, false, false, false, false, false, false, false, false },
                                { false, true, false, false, false, false, false, false, true, false },
                                { false, true, false, false, false, false, false, false, true, false },
                                { false, true, false, false, false, false, false, false, true, false },
                                { false, true, false, false, false, false, false, false, true, false },
                                { false, true, false, false, true, true, false, false, true, false },
                                { false, true, false, true, true, true, true, false, true, false },
                                { false, true, true, true, false, false, true, true, true, false },
                                { false, true, true, false, false, false, false, true, true, false },
                                { false, false, false, false, false, false, false, false, false, false }
                };
                letterDatabase.put('W', patternWMaj);

                boolean[][] patternXMaj = {
                                { true, false, false, false, false, false, false, false, false, true },
                                { true, true, false, false, false, false, false, false, true, true },
                                { false, true, true, false, false, false, false, true, true, false },
                                { false, false, true, true, false, false, true, true, false, false },
                                { false, false, false, true, true, true, true, false, false, false },
                                { false, false, false, true, true, true, true, false, false, false },
                                { false, false, true, true, false, false, true, true, false, false },
                                { false, true, true, false, false, false, false, true, true, false },
                                { true, true, false, false, false, false, false, false, true, true },
                                { true, false, false, false, false, false, false, false, false, true }
                };
                letterDatabase.put('X', patternXMaj);

                boolean[][] patternYMaj = {
                                { true, false, false, false, false, false, false, false, true, false },
                                { true, true, false, false, false, false, false, true, true, false },
                                { false, true, true, false, false, false, true, true, false, false },
                                { false, false, true, true, false, true, true, false, false, false },
                                { false, false, false, true, true, true, false, false, false, false },
                                { false, false, false, false, true, false, false, false, false, false },
                                { false, false, false, false, true, false, false, false, false, false },
                                { false, false, false, false, true, false, false, false, false, false },
                                { false, false, false, false, true, false, false, false, false, false },
                                { false, false, false, false, true, false, false, false, false, false }
                };
                letterDatabase.put('Y', patternYMaj);

                boolean[][] patternZMaj = {
                                { false, true, true, true, true, true, true, true, true, true },
                                { false, false, false, false, false, false, false, false, true, true },
                                { false, false, false, false, false, false, false, true, true, false },
                                { false, false, false, false, false, false, true, true, false, false },
                                { false, false, false, false, false, true, true, false, false, false },
                                { false, false, false, false, true, true, false, false, false, false },
                                { false, false, false, true, true, false, false, false, false, false },
                                { false, false, true, true, false, false, false, false, false, false },
                                { false, true, true, false, false, false, false, false, false, false },
                                { false, true, true, true, true, true, true, true, true, true }
                };
                letterDatabase.put('Z', patternZMaj);

                boolean[][] patternAMin = {
                                { false, false, false, false, false, false, false, false, false, false },
                                { false, false, false, false, true, true, true, true, false, false },
                                { false, false, false, true, false, false, false, true, false, false },
                                { false, false, false, true, false, false, false, true, false, false },
                                { false, false, false, true, false, false, false, true, false, false },
                                { false, false, false, false, true, true, true, true, true, true },
                                { false, false, false, false, false, false, false, false, false, false },
                                { false, false, false, false, false, false, false, false, false, false },
                                { false, false, false, false, false, false, false, false, false, false },
                                { false, false, false, false, false, false, false, false, false, false }
                };
                letterDatabase.put('a', patternAMin);

                boolean[][] patternBMin = {
                                { false, false, false, true, false, false, false, false, false, false },
                                { false, false, false, true, false, false, false, false, false, false },
                                { false, false, false, true, false, false, false, false, false, false },
                                { false, false, false, true, false, false, false, false, false, false },
                                { false, false, false, true, true, true, true, false, false, false },
                                { false, false, false, true, false, false, true, true, false, false },
                                { false, false, false, true, false, false, false, true, false, false },
                                { false, false, false, true, false, false, true, true, false, false },
                                { false, false, false, true, true, true, true, false, false, false },
                                { false, false, false, false, false, false, false, false, false, false }
                };
                letterDatabase.put('b', patternBMin);

                boolean[][] patternCMin = {
                                { false, false, false, false, false, false, false, false, false, false },
                                { false, false, false, false, false, false, false, false, false, false },
                                { false, false, false, false, false, false, false, false, false, false },
                                { false, false, false, true, true, true, false, false, false, false },
                                { false, false, true, true, false, false, false, false, false, false },
                                { false, false, true, false, false, false, false, false, false, false },
                                { false, false, true, true, false, false, false, false, false, false },
                                { false, false, false, true, true, true, false, false, false, false },
                                { false, false, false, false, false, false, false, false, false, false },
                                { false, false, false, false, false, false, false, false, false, false }
                };
                letterDatabase.put('c', patternCMin);

                boolean[][] patternDMin = {
                                { false, false, false, false, false, false, true, false, false, false },
                                { false, false, false, false, false, false, true, false, false, false },
                                { false, false, false, false, false, false, true, false, false, false },
                                { false, false, false, false, false, false, true, false, false, false },
                                { false, false, false, true, true, true, true, false, false, false },
                                { false, false, true, true, false, false, true, false, false, false },
                                { false, false, true, false, false, false, true, false, false, false },
                                { false, false, true, true, false, false, true, false, false, false },
                                { false, false, false, true, true, true, true, false, false, false },
                                { false, false, false, false, false, false, false, false, false, false }
                };
                letterDatabase.put('d', patternDMin);

                boolean[][] patternEMin = {
                                { false, false, false, false, false, false, false, false, false, false },
                                { false, false, false, true, true, true, false, false, false, false },
                                { false, false, true, false, false, false, true, false, false, false },
                                { false, false, true, false, false, false, true, false, false, false },
                                { false, false, true, true, true, true, true, false, false, false },
                                { false, false, true, false, false, false, false, false, false, false },
                                { false, false, true, true, false, false, false, false, false, false },
                                { false, false, false, true, true, true, true, true, false, false },
                                { false, false, false, false, false, false, false, false, false, false },
                                { false, false, false, false, false, false, false, false, false, false }
                };
                letterDatabase.put('e', patternEMin);

                boolean[][] patternFMin = {
                                { false, false, false, false, true, true, true, false, false, false },
                                { false, false, false, true, false, false, true, false, false, false },
                                { false, false, false, true, false, false, false, false, false, false },
                                { false, false, false, true, false, false, false, false, false, false },
                                { false, false, false, true, true, true, false, false, false, false },
                                { false, false, false, true, false, false, false, false, false, false },
                                { false, false, false, true, false, false, false, false, false, false },
                                { false, false, false, true, false, false, false, false, false, false },
                                { false, false, false, true, false, false, false, false, false, false },
                                { false, false, false, false, false, false, false, false, false, false }
                };
                letterDatabase.put('f', patternFMin);

                boolean[][] patternGMin = {
                                { false, false, false, false, false, false, true, false, false, false },
                                { false, false, false, true, true, true, true, false, false, false },
                                { false, false, true, false, false, false, true, false, false, false },
                                { false, false, true, false, false, false, true, false, false, false },
                                { false, false, false, true, true, true, true, false, false, false },
                                { false, false, false, false, false, false, true, false, false, false },
                                { false, false, false, false, false, false, true, false, false, false },
                                { false, false, true, false, false, true, true, false, false, false },
                                { false, false, false, true, true, true, false, false, false, false },
                                { false, false, false, false, false, false, false, false, false, false }
                };
                letterDatabase.put('g', patternGMin);

                boolean[][] patternHMin = {
                                { false, false, false, true, false, false, false, false, false, false },
                                { false, false, false, true, false, false, false, false, false, false },
                                { false, false, false, true, false, false, false, false, false, false },
                                { false, false, false, true, false, false, false, false, false, false },
                                { false, false, false, true, true, true, true, false, false, false },
                                { false, false, false, true, false, false, false, true, false, false },
                                { false, false, false, true, false, false, false, true, false, false },
                                { false, false, false, true, false, false, false, true, false, false },
                                { false, false, false, true, false, false, false, true, false, false },
                                { false, false, false, true, false, false, false, true, false, false }
                };
                letterDatabase.put('h', patternHMin);

                boolean[][] patternIMin = {
                                { false, false, false, false, false, false, false, false, false, false },
                                { false, false, false, false, false, false, false, false, false, false },
                                { false, false, false, false, false, true, false, false, false, false },
                                { false, false, false, false, false, false, false, false, false, false },
                                { false, false, false, false, false, true, false, false, false, false },
                                { false, false, false, false, false, true, false, false, false, false },
                                { false, false, false, false, false, true, false, false, false, false },
                                { false, false, false, false, false, true, false, false, false, false },
                                { false, false, false, false, false, true, false, false, false, false },
                                { false, false, false, false, false, false, false, false, false, false }
                };
                letterDatabase.put('i', patternIMin);

                boolean[][] patternJMin = {
                                { false, false, false, false, false, false, false, false, false, false },
                                { false, false, false, false, false, false, false, false, false, false },
                                { false, false, false, false, false, true, false, false, false, false },
                                { false, false, false, false, false, false, false, false, false, false },
                                { false, false, false, false, false, true, false, false, false, false },
                                { false, false, false, false, false, true, false, false, false, false },
                                { false, false, false, false, false, true, false, false, false, false },
                                { false, false, true, false, false, true, false, false, false, false },
                                { false, false, true, false, false, true, false, false, false, false },
                                { false, false, false, true, true, false, false, false, false, false }
                };
                letterDatabase.put('j', patternJMin);

                boolean[][] patternKMin = {
                                { false, false, false, false, true, true, false, false, false, false },
                                { false, false, false, true, false, false, true, false, false, false },
                                { false, false, false, true, false, false, true, false, false, false },
                                { false, false, false, true, false, false, true, false, false, false },
                                { false, false, false, true, false, true, false, false, false, false },
                                { false, false, false, true, true, true, true, false, false, false },
                                { false, false, false, true, false, false, true, false, false, false },
                                { false, false, false, true, true, true, false, false, false, false },
                                { false, false, false, true, false, true, true, false, false, false },
                                { false, false, false, true, false, false, true, false, false, false }
                };
                letterDatabase.put('k', patternKMin);

                boolean[][] patternLMin = {
                                { false, false, false, false, true, true, false, false, false, false },
                                { false, false, false, true, false, false, true, false, false, false },
                                { false, false, false, true, false, false, true, false, false, false },
                                { false, false, false, true, false, false, true, false, false, false },
                                { false, false, false, true, false, false, true, false, false, false },
                                { false, false, false, true, false, true, false, false, false, false },
                                { false, false, false, true, true, false, false, false, false, false },
                                { false, false, false, true, false, false, false, false, false, false },
                                { false, false, false, true, false, false, false, false, false, false },
                                { false, false, false, true, true, false, false, false, false, false }
                };
                letterDatabase.put('l', patternLMin);

                boolean[][] patternMMin = {
                                { false, false, false, false, false, false, false, false, false, false },
                                { false, false, false, false, false, false, false, false, false, false },
                                { false, false, false, false, false, false, false, false, false, false },
                                { false, true, false, false, false, false, false, false, false, false },
                                { false, true, true, true, true, false, true, true, true, false },
                                { false, true, false, false, true, true, true, false, true, true },
                                { false, true, false, false, false, true, false, false, false, true },
                                { false, true, false, false, false, true, false, false, false, true },
                                { false, true, false, false, false, true, false, false, false, true },
                                { false, true, false, false, false, true, false, false, false, true }
                };
                letterDatabase.put('m', patternMMin);

                boolean[][] patternNMin = {
                                { false, false, false, false, false, false, false, false, false, false },
                                { false, false, false, false, false, false, false, false, false, false },
                                { false, false, false, false, false, false, false, false, false, false },
                                { false, true, false, false, false, false, false, false, false, false },
                                { false, true, true, true, false, false, false, false, false, false },
                                { false, true, false, false, true, false, false, false, false, false },
                                { false, true, false, false, true, false, false, false, false, false },
                                { false, true, false, false, true, false, false, false, false, false },
                                { false, true, false, false, true, false, false, false, false, false },
                                { false, true, false, false, true, false, false, false, false, false }
                };
                letterDatabase.put('n', patternNMin);

                boolean[][] patternOMin = {
                                { false, false, false, false, false, false, false, false, false, false },
                                { false, false, false, false, false, false, false, false, false, false },
                                { false, false, false, false, true, true, false, false, false, false },
                                { false, false, false, true, false, false, true, false, false, false },
                                { false, false, true, false, false, false, false, true, false, false },
                                { false, false, true, false, false, false, false, true, false, false },
                                { false, false, false, true, false, false, true, false, false, false },
                                { false, false, false, false, true, true, false, false, false, false },
                                { false, false, false, false, false, false, false, false, false, false },
                                { false, false, false, false, false, false, false, false, false, false }
                };
                letterDatabase.put('o', patternOMin);

                boolean[][] patternPMin = {
                                { false, false, false, false, false, false, false, false, false, false },
                                { false, false, false, false, false, false, false, false, false, false },
                                { false, false, false, true, true, true, false, false, false, false },
                                { false, false, false, true, false, false, true, false, false, false },
                                { false, false, false, true, false, false, true, false, false, false },
                                { false, false, false, true, true, true, false, false, false, false },
                                { false, false, false, true, false, false, false, false, false, false },
                                { false, false, false, true, false, false, false, false, false, false },
                                { false, false, false, true, false, false, false, false, false, false },
                                { false, false, false, false, false, false, false, false, false, false }
                };
                letterDatabase.put('p', patternPMin);

                boolean[][] patternQMin = {
                                { false, false, false, false, false, false, false, false, false, false },
                                { false, false, false, false, false, false, false, false, false, false },
                                { false, false, false, false, true, true, true, false, false, false },
                                { false, false, false, true, false, false, true, false, false, false },
                                { false, false, false, true, false, false, true, false, false, false },
                                { false, false, false, false, true, true, true, false, false, false },
                                { false, false, false, false, false, false, true, false, false, false },
                                { false, false, false, false, false, false, true, false, false, false },
                                { false, false, false, false, false, false, true, false, false, false },
                                { false, false, false, false, false, false, false, false, false, false }
                };
                letterDatabase.put('q', patternQMin);

                boolean[][] patternRMin = {
                                { false, false, false, false, false, false, false, false, false, false },
                                { false, false, false, false, false, false, false, false, false, false },
                                { false, false, false, false, false, false, false, false, false, false },
                                { false, false, false, true, false, true, true, false, false, false },
                                { false, false, false, true, true, false, false, true, false, false },
                                { false, false, false, true, false, false, false, false, false, false },
                                { false, false, false, true, false, false, false, false, false, false },
                                { false, false, false, true, false, false, false, false, false, false },
                                { false, false, false, false, false, false, false, false, false, false },
                                { false, false, false, false, false, false, false, false, false, false }
                };
                letterDatabase.put('r', patternRMin);

                boolean[][] patternSMin = {
                                { false, false, false, false, false, false, false, false, false, false },
                                { false, false, false, false, false, false, false, false, false, false },
                                { false, false, false, false, false, false, false, false, false, false },
                                { false, false, false, false, true, true, true, false, false, false },
                                { false, false, false, true, false, false, false, false, false, false },
                                { false, false, false, true, false, false, false, false, false, false },
                                { false, false, false, false, true, true, true, false, false, false },
                                { false, false, false, false, false, false, false, true, false, false },
                                { false, false, false, false, false, false, false, true, false, false },
                                { false, false, false, false, true, true, true, false, false, false }
                };
                letterDatabase.put('s', patternSMin);

                boolean[][] patternTMin = {
                                { false, false, false, false, false, false, false, false, false, false },
                                { false, false, false, true, false, false, false, false, false, false },
                                { false, false, false, true, false, false, false, false, false, false },
                                { false, true, true, true, true, true, false, false, false, false },
                                { false, false, false, true, false, false, false, false, false, false },
                                { false, false, false, true, false, false, false, false, false, false },
                                { false, false, false, true, false, false, false, false, false, false },
                                { false, false, false, true, false, false, false, false, false, false },
                                { false, false, false, false, true, true, true, false, false, false },
                                { false, false, false, false, false, false, false, false, false, false }
                };
                letterDatabase.put('t', patternTMin);

                boolean[][] patternUMin = {
                                { false, false, false, false, false, false, false, false, false, false },
                                { false, false, false, false, false, false, false, false, false, false },
                                { false, false, false, false, false, false, false, false, false, false },
                                { false, false, true, false, false, true, false, false, false, false },
                                { false, false, true, false, false, true, false, false, false, false },
                                { false, false, true, false, false, true, false, false, false, false },
                                { false, false, true, true, true, true, false, false, false, false },
                                { false, false, false, false, false, false, false, false, false, false },
                                { false, false, false, false, false, false, false, false, false, false },
                                { false, false, false, false, false, false, false, false, false, false }
                };
                letterDatabase.put('u', patternUMin);

                boolean[][] patternVMin = {
                                { false, false, false, false, false, false, false, false, false, false },
                                { false, false, false, false, false, false, false, false, false, false },
                                { false, false, false, false, false, false, false, false, false, false },
                                { false, false, true, false, false, false, false, false, false, false },
                                { false, false, false, true, true, false, false, true, true, true },
                                { false, false, false, false, true, false, false, true, false, false },
                                { false, false, false, false, true, false, false, true, false, false },
                                { false, false, false, false, true, false, false, true, false, false },
                                { false, false, false, false, true, true, false, true, false, false },
                                { false, false, false, false, false, true, true, false, false, false }
                };
                letterDatabase.put('v', patternVMin);

                boolean[][] patternWMin = {
                                { false, false, false, false, false, false, false, false, false, false },
                                { false, false, false, false, false, false, false, false, false, false },
                                { false, false, false, false, false, false, false, false, false, false },
                                { false, false, false, false, false, false, false, false, false, false },
                                { false, true, false, false, false, true, false, false, false, true },
                                { false, true, false, false, false, true, false, false, false, true },
                                { false, true, false, false, false, true, false, false, false, true },
                                { false, true, false, false, false, true, false, false, false, true },
                                { false, false, true, true, true, false, true, true, true, false },
                                { false, false, false, false, false, false, false, false, false, false }
                };
                letterDatabase.put('w', patternWMin);

                boolean[][] patternXMin = {
                                { false, false, false, false, false, false, false, false, false, false },
                                { false, false, false, false, false, false, false, false, false, false },
                                { false, true, true, false, false, false, true, true, false, false },
                                { false, false, false, true, false, true, false, false, false, false },
                                { false, false, false, false, true, false, false, false, false, false },
                                { false, false, false, true, false, true, false, false, false, false },
                                { false, true, true, false, false, false, true, true, false, false },
                                { false, false, false, false, false, false, false, false, false, false },
                                { false, false, false, false, false, false, false, false, false, false },
                                { false, false, false, false, false, false, false, false, false, false }
                };
                letterDatabase.put('x', patternXMin);

                boolean[][] patternYMin = {
                                { false, false, false, false, false, false, false, false, false, false },
                                { false, false, false, false, false, false, false, false, false, false },
                                { false, false, true, false, false, false, false, true, false, false },
                                { false, false, true, true, false, false, true, true, false, false },
                                { false, false, false, true, true, false, true, false, false, false },
                                { false, false, false, false, true, true, true, false, false, false },
                                { false, false, false, false, false, true, true, false, false, false },
                                { false, false, false, false, true, true, false, false, false, false },
                                { false, false, true, true, true, false, false, false, false, false },
                                { false, false, false, false, false, false, false, false, false, false }
                };
                letterDatabase.put('y', patternYMin);

                boolean[][] patternZMin = {
                                { false, false, false, false, false, false, false, false, false, false },
                                { false, false, false, false, false, false, false, false, false, false },
                                { false, false, false, false, false, false, false, false, false, false },
                                { false, false, false, true, true, true, true, false, false, false },
                                { false, false, false, false, false, true, false, false, false, false },
                                { false, false, false, false, true, false, false, false, false, false },
                                { false, false, false, true, true, true, true, false, false, false },
                                { false, false, false, false, false, false, false, false, false, false },
                                { false, false, false, false, false, false, false, false, false, false },
                                { false, false, false, false, false, false, false, false, false, false }
                };
                letterDatabase.put('z', patternZMin);

                return letterDatabase;
        }

}