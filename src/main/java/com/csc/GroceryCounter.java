package com.csc;
import java.util.ArrayList;

public class GroceryCounter {
  int overloads = 0;

  int[] nums = {0,0,0,0};
  int[] remainder = {0,0,0,0};


  public void callMoney(int idx){
    switch(idx){
        case 0: tens();
                break;
        case 1: ones();
                break;
        case 2: tenths();
                break;
        case 3: hundredths();
                break;
    }
  }

  public Boolean overload(int idx){
    if((nums[idx]+1)> 9){
        if(idx>0){
            nums[idx] = 0;
            callMoney(idx-1);
            return true;
        } else {
            nums[idx] = 0;
            overloads++;
            return true;
        }
    }
    return false;
  }

  public int number_of_overloads() {
    return overloads;
  }

  public void tens(){
    boolean overloaded = overload(0);
    if (!overloaded){
        nums[0] += 1;
    }        
  }

  public void ones(){
    boolean overloaded = overload(1);
    if (!overloaded){
        nums[1] += 1;

    }        
  }

  public void tenths(){
    boolean overloaded = overload(2);
    if (!overloaded){
        nums[2] += 1;

    }        
  }

  public void hundredths(){
    boolean overloaded = overload(3);
    if (!overloaded){
        nums[3] += 1;

    }        
  }

  public String total(){
    if(nums[0] == 0){
            String s = "$" + String.valueOf(nums[1]) + 
                "." + String.valueOf(nums[2]) + String.valueOf(nums[3]);
                return s;

    } else {
            String s = "$" + String.valueOf(nums[0]) + String.valueOf(nums[1]) + 
            "." + String.valueOf(nums[2]) + String.valueOf(nums[3]);
            return s;

    }
  }

  public void clear(){
    for(int i = 0; i < 4; i++){
        nums[i] = 0;
    }
    overloads = 0;
  }
}
