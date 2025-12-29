package com.soloxp.data.local;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.soloxp.data.local.entity.QuestEntity;
import com.soloxp.data.local.entity.UserProfileEntity;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class SoloXpDao_Impl implements SoloXpDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<QuestEntity> __insertionAdapterOfQuestEntity;

  private final EntityInsertionAdapter<UserProfileEntity> __insertionAdapterOfUserProfileEntity;

  public SoloXpDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfQuestEntity = new EntityInsertionAdapter<QuestEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `quests` (`id`,`title`,`category`,`difficulty`,`durationMinutes`,`xpReward`,`instructions`,`successCriteria`,`isCompleted`,`createdAt`) VALUES (?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final QuestEntity entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getId());
        }
        if (entity.getTitle() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getTitle());
        }
        if (entity.getCategory() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getCategory());
        }
        if (entity.getDifficulty() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getDifficulty());
        }
        statement.bindLong(5, entity.getDurationMinutes());
        statement.bindLong(6, entity.getXpReward());
        if (entity.getInstructions() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getInstructions());
        }
        if (entity.getSuccessCriteria() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getSuccessCriteria());
        }
        final int _tmp = entity.isCompleted() ? 1 : 0;
        statement.bindLong(9, _tmp);
        statement.bindLong(10, entity.getCreatedAt());
      }
    };
    this.__insertionAdapterOfUserProfileEntity = new EntityInsertionAdapter<UserProfileEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `user_profile` (`id`,`tone`,`energyLevel`,`xpTotal`,`rank`,`fireCharges`,`preferredTimePerDay`) VALUES (?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final UserProfileEntity entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getId());
        }
        if (entity.getTone() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getTone());
        }
        statement.bindLong(3, entity.getEnergyLevel());
        statement.bindLong(4, entity.getXpTotal());
        if (entity.getRank() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getRank());
        }
        statement.bindLong(6, entity.getFireCharges());
        statement.bindLong(7, entity.getPreferredTimePerDay());
      }
    };
  }

  @Override
  public Object insertQuest(final QuestEntity quest, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfQuestEntity.insert(quest);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateUserProfile(final UserProfileEntity profile,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfUserProfileEntity.insert(profile);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<QuestEntity>> getAllQuests() {
    final String _sql = "SELECT * FROM quests ORDER BY createdAt DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"quests"}, new Callable<List<QuestEntity>>() {
      @Override
      @NonNull
      public List<QuestEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final int _cursorIndexOfDifficulty = CursorUtil.getColumnIndexOrThrow(_cursor, "difficulty");
          final int _cursorIndexOfDurationMinutes = CursorUtil.getColumnIndexOrThrow(_cursor, "durationMinutes");
          final int _cursorIndexOfXpReward = CursorUtil.getColumnIndexOrThrow(_cursor, "xpReward");
          final int _cursorIndexOfInstructions = CursorUtil.getColumnIndexOrThrow(_cursor, "instructions");
          final int _cursorIndexOfSuccessCriteria = CursorUtil.getColumnIndexOrThrow(_cursor, "successCriteria");
          final int _cursorIndexOfIsCompleted = CursorUtil.getColumnIndexOrThrow(_cursor, "isCompleted");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final List<QuestEntity> _result = new ArrayList<QuestEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final QuestEntity _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpCategory;
            if (_cursor.isNull(_cursorIndexOfCategory)) {
              _tmpCategory = null;
            } else {
              _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            }
            final String _tmpDifficulty;
            if (_cursor.isNull(_cursorIndexOfDifficulty)) {
              _tmpDifficulty = null;
            } else {
              _tmpDifficulty = _cursor.getString(_cursorIndexOfDifficulty);
            }
            final int _tmpDurationMinutes;
            _tmpDurationMinutes = _cursor.getInt(_cursorIndexOfDurationMinutes);
            final int _tmpXpReward;
            _tmpXpReward = _cursor.getInt(_cursorIndexOfXpReward);
            final String _tmpInstructions;
            if (_cursor.isNull(_cursorIndexOfInstructions)) {
              _tmpInstructions = null;
            } else {
              _tmpInstructions = _cursor.getString(_cursorIndexOfInstructions);
            }
            final String _tmpSuccessCriteria;
            if (_cursor.isNull(_cursorIndexOfSuccessCriteria)) {
              _tmpSuccessCriteria = null;
            } else {
              _tmpSuccessCriteria = _cursor.getString(_cursorIndexOfSuccessCriteria);
            }
            final boolean _tmpIsCompleted;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsCompleted);
            _tmpIsCompleted = _tmp != 0;
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            _item = new QuestEntity(_tmpId,_tmpTitle,_tmpCategory,_tmpDifficulty,_tmpDurationMinutes,_tmpXpReward,_tmpInstructions,_tmpSuccessCriteria,_tmpIsCompleted,_tmpCreatedAt);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<UserProfileEntity> getUserProfile() {
    final String _sql = "SELECT * FROM user_profile WHERE id = 'local_user'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"user_profile"}, new Callable<UserProfileEntity>() {
      @Override
      @Nullable
      public UserProfileEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTone = CursorUtil.getColumnIndexOrThrow(_cursor, "tone");
          final int _cursorIndexOfEnergyLevel = CursorUtil.getColumnIndexOrThrow(_cursor, "energyLevel");
          final int _cursorIndexOfXpTotal = CursorUtil.getColumnIndexOrThrow(_cursor, "xpTotal");
          final int _cursorIndexOfRank = CursorUtil.getColumnIndexOrThrow(_cursor, "rank");
          final int _cursorIndexOfFireCharges = CursorUtil.getColumnIndexOrThrow(_cursor, "fireCharges");
          final int _cursorIndexOfPreferredTimePerDay = CursorUtil.getColumnIndexOrThrow(_cursor, "preferredTimePerDay");
          final UserProfileEntity _result;
          if (_cursor.moveToFirst()) {
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpTone;
            if (_cursor.isNull(_cursorIndexOfTone)) {
              _tmpTone = null;
            } else {
              _tmpTone = _cursor.getString(_cursorIndexOfTone);
            }
            final int _tmpEnergyLevel;
            _tmpEnergyLevel = _cursor.getInt(_cursorIndexOfEnergyLevel);
            final long _tmpXpTotal;
            _tmpXpTotal = _cursor.getLong(_cursorIndexOfXpTotal);
            final String _tmpRank;
            if (_cursor.isNull(_cursorIndexOfRank)) {
              _tmpRank = null;
            } else {
              _tmpRank = _cursor.getString(_cursorIndexOfRank);
            }
            final int _tmpFireCharges;
            _tmpFireCharges = _cursor.getInt(_cursorIndexOfFireCharges);
            final int _tmpPreferredTimePerDay;
            _tmpPreferredTimePerDay = _cursor.getInt(_cursorIndexOfPreferredTimePerDay);
            _result = new UserProfileEntity(_tmpId,_tmpTone,_tmpEnergyLevel,_tmpXpTotal,_tmpRank,_tmpFireCharges,_tmpPreferredTimePerDay);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
