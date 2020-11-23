package service.implement;

import org.springframework.stereotype.Service;
import service.DictionaryService;

import java.util.HashMap;
import java.util.Map;


@Service
public class DictionaryServiceImpl implements DictionaryService {
    private static Map<String, String> dictionaryList;

    static {
        dictionaryList = new HashMap<>();

        dictionaryList.put("hello","Xin chào");
        dictionaryList.put("good night", "Chúc ngủ ngon");
        dictionaryList.put("good morning","Chào buổi sáng");
        dictionaryList.put("position","Vị trí");
        dictionaryList.put("element","Phần tử");
    }




    @Override
    public String search(String keyWord) {
        return dictionaryList.get(keyWord);
    }
}
