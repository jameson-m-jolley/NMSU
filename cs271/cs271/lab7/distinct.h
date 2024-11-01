

int distinct(int v1, int v2, int v3){
    int r =3 ;

    if(v1 == v2){
        r--;
    }//end of if
    if(v2 == v3){
        r--;
    }//end of if
    if(v1==v3){
        r--;
    }//end of if
    return r;
}// end of distinct