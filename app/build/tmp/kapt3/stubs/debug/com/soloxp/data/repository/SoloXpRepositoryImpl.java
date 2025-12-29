package com.soloxp.data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0096@\u00a2\u0006\u0002\u0010\tJ\u0014\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f0\u000bH\u0016J\u0010\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u000bH\u0016J\u0016\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000eH\u0096@\u00a2\u0006\u0002\u0010\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/soloxp/data/repository/SoloXpRepositoryImpl;", "Lcom/soloxp/data/repository/SoloXpRepository;", "dao", "Lcom/soloxp/data/local/SoloXpDao;", "(Lcom/soloxp/data/local/SoloXpDao;)V", "addQuest", "", "quest", "Lcom/soloxp/domain/model/Quest;", "(Lcom/soloxp/domain/model/Quest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getQuests", "Lkotlinx/coroutines/flow/Flow;", "", "getUserProfile", "Lcom/soloxp/domain/model/UserProfile;", "saveUserProfile", "profile", "(Lcom/soloxp/domain/model/UserProfile;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class SoloXpRepositoryImpl implements com.soloxp.data.repository.SoloXpRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.soloxp.data.local.SoloXpDao dao = null;
    
    public SoloXpRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.soloxp.data.local.SoloXpDao dao) {
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
}