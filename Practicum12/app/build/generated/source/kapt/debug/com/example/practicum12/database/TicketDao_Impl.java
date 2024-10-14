package com.example.practicum12.database;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import com.example.practicum12.Ticket;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Callable;
import kotlinx.coroutines.flow.Flow;

@SuppressWarnings({"unchecked", "deprecation"})
public final class TicketDao_Impl implements TicketDao {
  private final RoomDatabase __db;

  private final TicketTypeConverter __ticketTypeConverter = new TicketTypeConverter();

  public TicketDao_Impl(RoomDatabase __db) {
    this.__db = __db;
  }

  @Override
  public Flow<List<Ticket>> getTickets() {
    final String _sql = "SELECT * FROM ticket";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[]{"ticket"}, new Callable<List<Ticket>>() {
      @Override
      public List<Ticket> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfIsSolved = CursorUtil.getColumnIndexOrThrow(_cursor, "isSolved");
          final List<Ticket> _result = new ArrayList<Ticket>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Ticket _item;
            final UUID _tmpId;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfId);
            }
            _tmpId = __ticketTypeConverter.toUUID(_tmp);
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final Date _tmpDate;
            final long _tmp_1;
            _tmp_1 = _cursor.getLong(_cursorIndexOfDate);
            _tmpDate = __ticketTypeConverter.toDate(_tmp_1);
            final boolean _tmpIsSolved;
            final int _tmp_2;
            _tmp_2 = _cursor.getInt(_cursorIndexOfIsSolved);
            _tmpIsSolved = _tmp_2 != 0;
            _item = new Ticket(_tmpId,_tmpTitle,_tmpDate,_tmpIsSolved);
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
  public Flow<Ticket> getTicket(final UUID id) {
    final String _sql = "SELECT * FROM ticket WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    final String _tmp = __ticketTypeConverter.fromUUID(id);
    if (_tmp == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, _tmp);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[]{"ticket"}, new Callable<Ticket>() {
      @Override
      public Ticket call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfIsSolved = CursorUtil.getColumnIndexOrThrow(_cursor, "isSolved");
          final Ticket _result;
          if(_cursor.moveToFirst()) {
            final UUID _tmpId;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfId);
            }
            _tmpId = __ticketTypeConverter.toUUID(_tmp_1);
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final Date _tmpDate;
            final long _tmp_2;
            _tmp_2 = _cursor.getLong(_cursorIndexOfDate);
            _tmpDate = __ticketTypeConverter.toDate(_tmp_2);
            final boolean _tmpIsSolved;
            final int _tmp_3;
            _tmp_3 = _cursor.getInt(_cursorIndexOfIsSolved);
            _tmpIsSolved = _tmp_3 != 0;
            _result = new Ticket(_tmpId,_tmpTitle,_tmpDate,_tmpIsSolved);
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

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
