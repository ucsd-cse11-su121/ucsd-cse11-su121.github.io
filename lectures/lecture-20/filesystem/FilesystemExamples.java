import tester.*;
import java.util.List;

 // Challenge: implement and test countFiles, which takes no arguments and
  // returns the total number of File objects contained within a Folder1/Folder2
  // and all of its subfolders

  // Challenge: implement and test containsString, which takes a string to
  // search for in a directory and returns true if any file found in that
  // directory contains a file whose contents contains that string

  // Challenge: implement and test totalSize, which takes no arguments and
  // returns the total count of characters in all the files in that directory
  // structure.

interface FolderContent {
    boolean containsFile(String name);
    public int countFiles();
    public boolean containsString(String str);
    public int totalSize();    
}

class File implements FolderContent {
    String name;
    String contents;
    File(String name, String contents) {
        this.name = name;
        this.contents = contents;
    }

    public boolean containsFile(String name) {
        return this.name.equals(name);
    }

    public int countFiles() {
        return 1;
    }

    public boolean containsString(String str) {
        //System.out.println("file containsString: " + str);
        return this.contents.contains(str);
    }

    public int totalSize() {
        //System.out.println("file totalSize: " + this.contents.length());
        return this.contents.length();
    }
}

class Folder1 implements FolderContent {
    String name;
    List<FolderContent> contents;
    Folder1(String name, List<FolderContent> contents) {
        this.name = name;
        this.contents = contents;
    }

    public boolean containsFile(String name) {
        for (FolderContent fc: this.contents) {
            if (fc.containsFile(name)) {
                return true;
            }
        }

        return false;
    }

    public int countFiles() {
        int count = 0;

        for (FolderContent fc: this.contents) {
            count += fc.countFiles();
        }

        return count;
    }

    public boolean containsString(String str) {
        for (FolderContent fc: this.contents) {
            if (fc.containsString(str)) {
                return true;
            }
        }

        return false;
    }

    public int totalSize() {
        int count = 0;

        for (FolderContent fc: this.contents) {
            count += fc.totalSize();
        }

        return count;
    }
}

class Folder2 {
    String name;
    List<File> files;
    List<Folder2> folders;
    Folder2(String name, List<File> files, List<Folder2> folders) {
        this.name = name;
        this.files = files;
        this.folders = folders;
    }

    public boolean containsFile(String name) {
        for (File f: this.files) {
            if (f.containsFile(name)) {
                return true;
            }
        }

        for (Folder2 f: this.folders) {
            if (f.containsFile(name)) {
                return true;
            }
        }

        return false;
    }

    public int countFiles() {
        int count = files.size();

        for (Folder2 f: this.folders) {
            count += f.countFiles();
        }

        return count;
    }

    public boolean containsString(String str) {
        for (File f: this.files) {
            if (f.containsString(str)) {
                return true;
            }
        }

        for (Folder2 f: this.folders) {
            if (f.containsString(str)) {
                return true;
            }
        }

        return false;
    }

    public int totalSize() {
        int count = 0;

        for (File f: this.files) {
            count += f.totalSize();
        }

        for (Folder2 f: this.folders) {
            count += f.totalSize();
        }

        return count;
    }
}

class FilesystemExamples {

    Folder1 dictionaries = new Folder1("dictionaries", List.of());
    Folder1 poems = new Folder1("poems", List.of(new File("haiku.txt", "")));
    Folder1 textfiles = new Folder1( 
        "textfiles",
        List.of(dictionaries, poems, new File("words.txt", "hello\ngoodbye\na\ncat"))
    );

    Folder1 lecture19f1 = new Folder1(
        "filesystem",
        List.of(new File("FilesystemExamples.java", "<java code>"), textfiles)
    );

    /************************************************************************************* */

    Folder2 dictionaries2 = new Folder2("dictionaries", List.of(), List.of());
    Folder2 poems2 = new Folder2("poems", List.of(new File("haiku.txt", "")), List.of());
    Folder2 textfiles2 = new Folder2("textfiles", 
        List.of(new File("words.txt", "hello\ngoodbye\na\ncat")), 
        List.of(dictionaries2, poems2)
    );

    Folder2 lecture19f2 = new Folder2(
        "filesystem",
        List.of(new File("FilesystemExamples.java", "<java code>")),
        List.of(textfiles2)
    );

    void testContainsFile(Tester t) {
        t.checkExpect(lecture19f1.containsFile("haiku.txt"), true);
        t.checkExpect(lecture19f1.containsFile("notthere.txt"), false);
        t.checkExpect(dictionaries.containsFile("haiku.txt"), false);
        t.checkExpect(textfiles.containsFile("FilesystemExamples.java"), false);

        t.checkExpect(lecture19f2.containsFile("haiku.txt"), true);
        t.checkExpect(lecture19f2.containsFile("notthere.txt"), false);
        t.checkExpect(dictionaries2.containsFile("haiku.txt"), false);
        t.checkExpect(textfiles2.containsFile("FilesystemExamples.java"), false);
    }

    void testCountFiles(Tester t) {
        t.checkExpect(lecture19f1.countFiles(), 3);
        t.checkExpect(lecture19f2.countFiles(), 3);
    }

    void testContainsString(Tester t) {
        t.checkExpect(lecture19f1.containsString("cat"), true);
        t.checkExpect(lecture19f1.containsString("notext"), false);

        t.checkExpect(lecture19f2.containsString("cat"), true);
        t.checkExpect(lecture19f2.containsString("notext"), false);
    }

    void testTotalSize(Tester t) {
        System.out.println("Folder1 totalSize=" + lecture19f1.totalSize());
        System.out.println("Folder2 totalSize=" + lecture19f2.totalSize());

        t.checkExpect(lecture19f1.totalSize(), 30);
        t.checkExpect(lecture19f2.totalSize(), 30);
    }
}
