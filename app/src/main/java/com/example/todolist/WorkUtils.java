package com.example.todolist;

import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class WorkUtils  {
    private List<Work> worksData;
    private int rowId = 1;
    private static WorkUtils workUtils;

    private WorkUtils() {
        worksData = new ArrayList<>();
    }

    public static WorkUtils getInstance(){
        if (workUtils == null){
            workUtils = new WorkUtils();
        }
        return workUtils;
    }

    public void addWork(Work work){
        work.setId(rowId++);
        worksData.add(work);
    }

    public void deleteWork(int id){
        int index = -1;
        for(int i = 0; i < worksData.size(); i++){
            if(worksData.get(i).getId() == id) {
                index = i;
                break;
            }
        }
        worksData.remove(index);
    }

    public void sort(boolean isNewDates) {
//        int indexPlusOne;
//        for (int i = 0; i < worksData.size(); i++) {
//                indexPlusOne = i + 1;
//                if (indexPlusOne <= worksData.size() - 1) {
//                    if (isNewDates) {
//                        if (worksData.get(indexPlusOne).getCreatedDateMilliSeconds() > worksData.get(i).getCreatedDateMilliSeconds()) {
//                            Work tmpWork = worksData.get(i);
//                            worksData.set(i, worksData.get(indexPlusOne));
//                            worksData.set(indexPlusOne, tmpWork);
//                        }
//                    } else {
//                        if (worksData.get(indexPlusOne).getCreatedDateMilliSeconds() < worksData.get(i).getCreatedDateMilliSeconds()) {
//                            Work tmpWork = worksData.get(indexPlusOne);
//                            worksData.set(i, tmpWork);
//                            worksData.set(indexPlusOne, tmpWork);
//                        }
//                    }
//                }
//        }
        Collections.sort(worksData, new Comparator<Work>() {
            @Override
            public int compare(Work work1, Work work2) {
                if (isNewDates) {
                    return (int) (work2.getCreatedDateMilliSeconds() - work1.getCreatedDateMilliSeconds());
                }
                return (int) (work1.getCreatedDateMilliSeconds() - work2.getCreatedDateMilliSeconds());
            }
        });
    }


    public int getRowId() {
        return rowId;
    }

    public List<Work> getAll(){
        return worksData;
    }

    private Work getWork(int id) {
        for (Work work : worksData) {
            if (work.getId() == id) {
                return work;
            }
        }
        return null;
    }
}
