// Copyright (c) 2022 NetEase, Inc. All rights reserved.
// Use of this source code is governed by a MIT license that can be
// found in the LICENSE file.

package com.netease.yunxin.kit.teamkit.ui.fun.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.netease.nimlib.sdk.team.constant.TeamTypeEnum;
import com.netease.yunxin.kit.corekit.im.IMKitClient;
import com.netease.yunxin.kit.corekit.im.utils.RouterConstant;
import com.netease.yunxin.kit.teamkit.ui.R;
import com.netease.yunxin.kit.teamkit.ui.activity.BaseTeamManagerListActivity;
import com.netease.yunxin.kit.teamkit.ui.adapter.BaseTeamMemberListAdapter;
import com.netease.yunxin.kit.teamkit.ui.databinding.FunTeamManagerListActivityBinding;
import com.netease.yunxin.kit.teamkit.ui.databinding.FunTeamMemberListItemBinding;
import com.netease.yunxin.kit.teamkit.ui.fun.adapter.FunTeamMemberListAdapter;
import com.netease.yunxin.kit.teamkit.ui.utils.TeamUIKitConstant;
import com.netease.yunxin.kit.teamkit.ui.utils.TeamUtils;
import java.util.ArrayList;

public class FunTeamManagerListActivity extends BaseTeamManagerListActivity {
  private FunTeamManagerListActivityBinding viewBinding;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    changeStatusBarColor(R.color.color_ededed);
  }

  @Override
  protected View initViewAndGetRootView(Bundle savedInstanceState) {
    viewBinding = FunTeamManagerListActivityBinding.inflate(getLayoutInflater());
    ivBack = viewBinding.ivBack;
    tvAddManager = viewBinding.tvManager;
    rvMemberList = viewBinding.rvMemberList;
    groupEmpty = viewBinding.groupEmtpy;
    return viewBinding.getRoot();
  }

  @Override
  protected BaseTeamMemberListAdapter<? extends ViewBinding> getMemberListAdapter(
      TeamTypeEnum typeEnum) {
    FunTeamMemberListAdapter adapter =
        new FunTeamMemberListAdapter(this, typeEnum, FunTeamMemberListItemBinding.class);
    return adapter;
  }

  @Override
  protected void startTeamMemberSelector(ActivityResultLauncher launcher) {
    Intent intent = new Intent(this, FunTeamMemberSelectActivity.class);
    intent.putExtra(TeamUIKitConstant.KEY_TEAM_INFO, teamInfo);
    ArrayList<String> filterList = TeamUtils.getAccIdListFromInfoList(managerList);
    filterList.add(IMKitClient.account());
    intent.putExtra(RouterConstant.SELECTOR_CONTACT_FILTER_KEY, filterList);
    intent.putExtra(
        RouterConstant.KEY_CONTACT_SELECTOR_MAX_COUNT,
        TeamUIKitConstant.KEY_MANAGER_MAX_COUNT - managerList.size());
    launcher.launch(intent);
  }
}
