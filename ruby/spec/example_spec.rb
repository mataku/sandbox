require 'spec_helper'

describe 'Webmock example' do
  context 'GET' do
    before do
      stub_request(:get, 'test.example.com').to_return(
        body: '{"key": "value"}',
        status: 200,
        headers: { 'Content-Type': 'application/json' }
      )
    end

    it do
      res = Net::HTTP.get('test.example.com', '/')
    end
  end
end
