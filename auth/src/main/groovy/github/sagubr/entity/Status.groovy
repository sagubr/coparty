package github.sagubr.entity

enum Status {
    ACTIVED(0),
    DESACTIVE(1),
    SUSPEND(2)

    private Integer index

    Status(Integer index){
        this.index = index
    }

    Integer getIndex() {
        return index
    }
}