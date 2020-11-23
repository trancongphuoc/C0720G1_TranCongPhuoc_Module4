package service.implement;

import model.Dictionary;
import org.springframework.stereotype.Service;
import service.DictionaryService;

import java.util.HashMap;
import java.util.Map;


@Service
public class DictionaryServiceImpl implements DictionaryService {
    private static Map<String, Dictionary> dictionaryList;

    static {
        dictionaryList = new HashMap<>();

        dictionaryList.put("hello",new Dictionary("hello", "Xin chào"));
        dictionaryList.put("good night",new Dictionary("good night", "Chúc ngủ ngon"));
        dictionaryList.put("good morning",new Dictionary("good morning", "Chào buổi sáng"));
        dictionaryList.put("position",new Dictionary("position", "Vị trí"));
        dictionaryList.put("element",new Dictionary("element", "Phần tử"));
    }




    @Override
    public Dictionary search(String keyWord) {
        return dictionaryList.get(keyWord);
    }
}
