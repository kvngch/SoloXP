package com.soloxp.data.local;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&\u00a8\u0006\u0007"}, d2 = {"Lcom/soloxp/data/local/SoloXpDatabase;", "Landroidx/room/RoomDatabase;", "()V", "dao", "Lcom/soloxp/data/local/SoloXpDao;", "itemDao", "Lcom/soloxp/data/local/dao/ItemDao;", "app_debug"})
@androidx.room.Database(entities = {com.soloxp.data.local.entity.QuestEntity.class, com.soloxp.data.local.entity.UserProfileEntity.class, com.soloxp.data.local.entity.ItemEntity.class}, version = 2)
public abstract class SoloXpDatabase extends androidx.room.RoomDatabase {
    
    public SoloXpDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.soloxp.data.local.SoloXpDao dao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.soloxp.data.local.dao.ItemDao itemDao();
}