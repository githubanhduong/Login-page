package service;

import model.User;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RankService {
    public static void sortPlayer(List<User> userList){
        Collections.sort(userList, new Comparator<User>() {
            @Override
            public int compare(User p1, User p2) {
                return p1.getAchievement() - p2.getAchievement();
            }
        });
    }
}
