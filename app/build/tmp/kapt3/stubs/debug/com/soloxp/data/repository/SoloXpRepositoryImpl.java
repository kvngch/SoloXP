package com.soloxp.data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0096@\u00a2\u0006\u0002\u0010\u000bJ\u0016\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH\u0096@\u00a2\u0006\u0002\u0010\u000fJ\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0011\u001a\u00020\u0012H\u0096@\u00a2\u0006\u0002\u0010\u0013J\u0014\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00160\u0015H\u0016J\u0014\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00160\u0015H\u0016J\u0010\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0015H\u0016J\u0016\u0010\u001a\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH\u0096@\u00a2\u0006\u0002\u0010\u000fJ\u0016\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u0019H\u0096@\u00a2\u0006\u0002\u0010\u001dJ\u0016\u0010\u001e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0096@\u00a2\u0006\u0002\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2 = {"Lcom/soloxp/data/repository/SoloXpRepositoryImpl;", "Lcom/soloxp/data/repository/SoloXpRepository;", "dao", "Lcom/soloxp/data/local/SoloXpDao;", "itemDao", "Lcom/soloxp/data/local/dao/ItemDao;", "(Lcom/soloxp/data/local/SoloXpDao;Lcom/soloxp/data/local/dao/ItemDao;)V", "addQuest", "", "quest", "Lcom/soloxp/domain/model/Quest;", "(Lcom/soloxp/domain/model/Quest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteItem", "item", "Lcom/soloxp/domain/model/Item;", "(Lcom/soloxp/domain/model/Item;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getItemById", "id", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getItems", "Lkotlinx/coroutines/flow/Flow;", "", "getQuests", "getUserProfile", "Lcom/soloxp/domain/model/UserProfile;", "saveItem", "saveUserProfile", "profile", "(Lcom/soloxp/domain/model/UserProfile;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateQuest", "app_debug"})
public final class SoloXpRepositoryImpl implements com.soloxp.data.repository.SoloXpRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.soloxp.data.local.SoloXpDao dao = null;
    @org.jetbrains.annotations.NotNull()
    private final com.soloxp.data.local.dao.ItemDao itemDao = null;
    
    public SoloXpRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.soloxp.data.local.SoloXpDao dao, @org.jetbrains.annotations.NotNull()
    com.soloxp.data.local.dao.ItemDao itemDao) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<java.util.List<com.soloxp.domain.model.Quest>> getQuests() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object addQuest(@org.jetbrains.annotations.NotNull()
    com.soloxp.domain.model.Quest quest, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object updateQuest(@org.jetbrains.annotations.NotNull()
    com.soloxp.domain.model.Quest quest, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<com.soloxp.domain.model.UserProfile> getUserProfile() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object saveUserProfile(@org.jetbrains.annotations.NotNull()
    com.soloxp.domain.model.UserProfile profile, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<java.util.List<com.soloxp.domain.model.Item>> getItems() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object saveItem(@org.jetbrains.annotations.NotNull()
    com.soloxp.domain.model.Item item, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object deleteItem(@org.jetbrains.annotations.NotNull()
    com.soloxp.domain.model.Item item, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getItemById(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.soloxp.domain.model.Item> $completion) {
        return null;
    }
}