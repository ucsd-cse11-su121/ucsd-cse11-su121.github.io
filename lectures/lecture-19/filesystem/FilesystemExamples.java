import tester.*;
import java.util.List;

interface FolderContent {

}

class File implements FolderContent {
    String name;
    String contents;
    File(String name, String contents) {
        this.name = name;
        this.contents = contents;
    }
}

class Folder1 implements FolderContent {
    String name;
    List<FolderContent> contents;
    Folder1(String name, List<FolderContent> contents) {
        this.name = name;
        this.contents = contents;
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
}

class FilesystemExamples {

    Folder1 dictionaries = new Folder1("dictionaries", List.of());
    Folder1 poems = new Folder1("poems", List.of(new File("haiku.txt", "")));
    Folder1 textfiles = new Folder1( 
        "textfiles",
        List.of(dictionaries, poems, new File("words.txt", "hello\ngoodbye\na\ncat"))
    );

    Folder1 lecture19f1 = new Folder1(
        "lecture-19",
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
        "lecture-19",
        List.of(new File("FilesystemExamples.java", "<java code>")),
        List.of(textfiles2)
    );
}
