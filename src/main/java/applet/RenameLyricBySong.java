package applet;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author l
 * @date 2024/2/4 15:37
 * @description
 *
 * 根据歌曲的名字，把歌词重命名。
 *例 ：
 * 名称是：陈奕迅 - 一丝不挂.flac
 * 歌词命名前的名称 ：一丝不挂-MusicEnc.lrc
 * 歌词命名后的名称 ：陈奕迅 - 一丝不挂.lrc
 */
public class RenameLyricBySong {
    // 歌曲路径 (修改成自己的)
//    private final static String PATH_SONGS = "E:\\Download\\music\\新建文件夹\\新建文件夹\\新建文件夹\\1songs";
    private final static String PATH_SONGS = "D:\\javaxxz\\Adele\\1";
    // 歌词路径 (修改成自己的)
//    private final static String PATH_LYRIC = "E:\\Download\\music\\新建文件夹\\新建文件夹\\新建文件夹\\1lyric";
    private final static String PATH_LYRIC = "D:\\javaxxz\\Adele\\2";

    private final static String TYPE_SONG = "song";
    private final static String TYPE_LYRIC = "lyric";

    public static void main(String[] args) {

        RenameLyricBySong renameLyricBySong = new RenameLyricBySong();
        renameLyricBySong.renameBusiness();
//        String shortNameByLyric = renameLyricBySong.getShortNameByLyric("Shall We Talk-MusicEnc.lrc");
//        String shortNameByLyric = renameLyricBySong.getShortNameBySong("伍佰 - 爱的大道.flac");
//        System.out.println(shortNameByLyric);

    }

    public void renameBusiness(){
        List<String> notFindLyricOfSongList = new ArrayList<>();
        try {
            Map<String, FileBean> songsMap = getFileMap(PATH_SONGS, TYPE_SONG);
            Map<String, FileBean> lyricMap = getFileMap(PATH_LYRIC, TYPE_LYRIC);
            songsMap.entrySet().stream().forEach(entry -> {
                FileBean beanSong = entry.getValue();
                String userName = cleanSuffixal(beanSong.getOriginalName(),null).trim();
                if(lyricMap.containsKey(beanSong.getShortName().toUpperCase())){
                    FileBean beanLyric = lyricMap.get(beanSong.getShortName().toUpperCase());
                    File file = new File(beanLyric.getPath());
                    String newFileName = userName+beanLyric.getSuffixal();
                    File newFile = new File(beanLyric.getParentPath()+"\\"+newFileName);
//                    System.out.println(beanLyric.getOriginalName());
//                    System.out.println(newFileName);
                    //  确保新的文件名不存在
                    if (newFile.exists()){
                        System.out.println(newFileName+" file exists");
                        return;
                    }
                    if(!file.renameTo(newFile)){
                        System.out.println(newFileName+" 文件命名失败。");
                        return;
                    }
                }else {
//                    notFindLyricOfSongList.add(beanSong.getShortName());
                    notFindLyricOfSongList.add(userName);
                }
            });

            System.out.println("=========================== 没有找到对应歌词的歌曲列表 ==================================");
            for (String s : notFindLyricOfSongList) {
                System.out.println(s);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }


    }





    /**
     * 读取目录返回目录里文件列表
     * @param path 目录路径
     * @param type TYPE_SONG,TYPE_LYRIC
     *
     * */
    public Map<String, FileBean> getFileMap(String path,String type) throws Exception {
        HashMap<String, FileBean> fileMAP = new HashMap<>();
        File  dir = new File(path);
        if (!dir.exists()){
            throw new Exception("目录\""+path+"\"不存在!");
        }

        File[] files = dir.listFiles();
        assert files != null;

        for (File file : files) {
            if (file.isDirectory()){
                fileMAP.putAll(getFileMap(file.getAbsolutePath(),type));
            }else {
                FileBean bean = new FileBean();
                String name = file.getName();
                bean.setOriginalName(name);
                String shortName = "";
                if (TYPE_LYRIC.equals(type)){
                    shortName = getShortNameByLyric(name);
                }else {
                    shortName = getShortNameBySong(name);
                }
                bean.setShortName(shortName);
                bean.setPath(file.getAbsolutePath());
                bean.setSuffixal("."+getExtension(name));
                bean.setParentPath(file.getParent());
                if (fileMAP.containsKey(shortName.toUpperCase())){
                    throw new Exception(shortName+" 名称有重复！ type:"+type +"   name:"+name);
                }else {
                    fileMAP.put(shortName.toUpperCase(),bean);
                }

            }
        }

        return fileMAP;


    }

    private String getShortNameByLyric(String name){
        String shorName;
        String suffixal = "-MusicEnc";
//        String suffixal = ".lrc";
        shorName = name.substring(0,name.indexOf(suffixal));

        return shorName.trim();
    }

    private String getShortNameBySong(String name){
        String shorName="";
        String[] suffixalArr = {".flac",".mp3",".wav"};
        int secondIndex =-1;
        for (String s : suffixalArr) {
            secondIndex = name.indexOf(s);
            if (secondIndex != -1){
                int firstIndex = name.indexOf("-");
                shorName = name.substring(firstIndex+1,secondIndex);
                break;
            }

        }

        return shorName.trim();
    }

    private String cleanSuffixal(String fileName,String suffixal){
        String[] suffixalArr = {".flac",".mp3",".lrc",".wav"};
        if (suffixal != null && suffixal != ""){
            suffixalArr[2] = suffixal;
        }
        int lastIndex = -1;
        for (String s : suffixalArr) {
            lastIndex = fileName.indexOf(s);
            if (lastIndex != -1)
                break;
        }
        if(lastIndex >0 ){
            fileName = fileName.substring(0,lastIndex);
        }
        return fileName;
    }

    public static String getExtension(String fileName){
        String suffixal = fileName.split("\\.")[fileName.split("\\.").length-1];
        return suffixal.trim();
    }



    class FileBean{
        String shortName;
        String originalName;
        String path;
        /**
         * 文件所在目录名，不包含文件名。
         * */
        String parentPath;
        String suffixal;



        public String getShortName() {
            return shortName;
        }

        public void setShortName(String shortName) {
            this.shortName = shortName;
        }

        public String getOriginalName() {
            return originalName;
        }

        public void setOriginalName(String originalName) {
            this.originalName = originalName;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        @Override
        public String toString() {
            return "Lyric{" +
                    "shortName='" + shortName + '\'' +
                    ", originalName='" + originalName + '\'' +
                    ", path='" + path + '\'' +
                    '}';
        }

        public String getSuffixal() {
            return suffixal;
        }

        public void setSuffixal(String suffixal) {
            this.suffixal = suffixal;
        }


        /**
         * 文件所在目录名，不包含文件名。
         * */
        public String getParentPath() {
            return parentPath;
        }
        /**
         * 文件所在目录名，不包含文件名。
         * */
        public void setParentPath(String parentPath) {
            this.parentPath = parentPath;
        }

    }
}


